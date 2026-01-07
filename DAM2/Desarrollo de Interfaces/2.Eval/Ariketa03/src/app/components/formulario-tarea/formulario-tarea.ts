import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { TareaService } from '../../services/tarea.service';

@Component({
  selector: 'app-formulario-tarea',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './formulario-tarea.html',
  styleUrls: ['./formulario-tarea.css']
})
export class FormularioTareaComponent implements OnInit {
  tareaForm: FormGroup;
  esEdicion = false;
  tareaId?: number;

  constructor(
    private fb: FormBuilder,
    private tareaService: TareaService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.tareaForm = this.fb.group({
      titulo: ['', [Validators.required, Validators.minLength(3)]],
      descripcion: ['', [Validators.required, Validators.minLength(10)]],
      prioridad: ['media', Validators.required],
      completada: [false]
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.esEdicion = true;
        this.tareaId = +params['id'];
        this.cargarTarea(this.tareaId);
      }
    });
  }

  cargarTarea(id: number): void {
    this.tareaService.getTarea(id).subscribe(tarea => {
      if (tarea) {
        this.tareaForm.patchValue({
          titulo: tarea.titulo,
          descripcion: tarea.descripcion,
          prioridad: tarea.prioridad,
          completada: tarea.completada
        });
      }
    });
  }

  onSubmit(): void {
    if (this.tareaForm.valid) {
      if (this.esEdicion && this.tareaId) {
        this.tareaService.actualizarTarea(this.tareaId, this.tareaForm.value);
      } else {
        const nuevaTarea = {
          ...this.tareaForm.value,
          fechaCreacion: new Date().toLocaleDateString('es-ES')
        };
        this.tareaService.agregarTarea(nuevaTarea);
      }
      this.router.navigate(['/']);
    } else {
      this.marcarCamposComoTocados();
    }
  }

  marcarCamposComoTocados(): void {
    Object.keys(this.tareaForm.controls).forEach(key => {
      this.tareaForm.get(key)?.markAsTouched();
    });
  }

  cancelar(): void {
    this.router.navigate(['/']);
  }

  esInvalido(campo: string): boolean {
    const control = this.tareaForm.get(campo);
    return !!(control && control.invalid && control.touched);
  }

  obtenerMensajeError(campo: string): string {
    const control = this.tareaForm.get(campo);
    if (control?.hasError('required')) {
      return 'Este campo es obligatorio';
    }
    if (control?.hasError('minlength')) {
      const minLength = control.errors?.['minlength'].requiredLength;
      return `Mínimo ${minLength} caracteres`;
    }
    return '';
  }
}
