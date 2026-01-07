import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { TareaService } from '../../services/tarea.service';
import { Tarea } from '../../interfaces/tarea';

@Component({
  selector: 'app-lista-tareas',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './lista-tareas.html',
  styleUrls: ['./lista-tareas.css']
})
export class ListaTareasComponent implements OnInit {
  tareas: Tarea[] = [];
  filtroActual: string = 'todas';

  constructor(private tareaService: TareaService) {}

  ngOnInit(): void {
    this.tareaService.getTareas().subscribe(tareas => {
      this.tareas = tareas;
    });
  }

  get tareasFiltradas(): Tarea[] {
    switch (this.filtroActual) {
      case 'completadas':
        return this.tareas.filter(t => t.completada);
      case 'pendientes':
        return this.tareas.filter(t => !t.completada);
      default:
        return this.tareas;
    }
  }

  get tareasCompletadas(): number {
    return this.tareas.filter(t => t.completada).length;
  }

  get tareasPendientes(): number {
    return this.tareas.filter(t => !t.completada).length;
  }

  toggleCompletada(id: number): void {
    this.tareaService.toggleCompletada(id);
  }

  eliminarTarea(id: number): void {
    if (confirm('¿Estás seguro de que deseas eliminar esta tarea?')) {
      this.tareaService.eliminarTarea(id);
    }
  }

  cambiarFiltro(filtro: string): void {
    this.filtroActual = filtro;
  }

  getPrioridadClass(prioridad: string): string {
    return `prioridad-${prioridad}`;
  }
}
