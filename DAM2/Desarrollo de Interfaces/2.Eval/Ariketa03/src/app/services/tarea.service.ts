import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, interval, of } from 'rxjs';
import { switchMap, tap, catchError } from 'rxjs/operators';
import { Tarea } from '../interfaces/tarea';

@Injectable({
  providedIn: 'root'
})
export class TareaService {
  private apiUrl = 'http://localhost/server/api.php';
  private tareasSubject = new BehaviorSubject<Tarea[]>([]);
  public tareas$ = this.tareasSubject.asObservable();

  constructor(private http: HttpClient) {
    this.cargarTareas();
    // Actualización en tiempo real cada 5 segundos
    this.iniciarActualizacionAutomatica();
  }

  private iniciarActualizacionAutomatica(): void {
    interval(5000)
      .pipe(
        switchMap(() => this.http.get<Tarea[]>(this.apiUrl)),
        catchError(error => {
          console.error('Error al actualizar tareas:', error);
          return of([]);
        })
      )
      .subscribe(tareas => {
        if (tareas && tareas.length >= 0) {
          this.tareasSubject.next(tareas);
        }
      });
  }

  cargarTareas(): void {
    this.http.get<Tarea[]>(this.apiUrl).subscribe({
      next: (tareas) => {
        this.tareasSubject.next(tareas);
      },
      error: (error) => {
        console.error('Error al cargar tareas:', error);
        this.tareasSubject.next([]);
      }
    });
  }

  getTareas(): Observable<Tarea[]> {
    return this.tareas$;
  }

  getTarea(id: number): Observable<Tarea | undefined> {
    return this.http.get<Tarea>(`${this.apiUrl}?id=${id}`).pipe(
      catchError(error => {
        console.error('Error al obtener tarea:', error);
        return of(undefined);
      })
    );
  }

  agregarTarea(tarea: Omit<Tarea, 'id'>): void {
    this.http.post<Tarea>(this.apiUrl, tarea).subscribe({
      next: (nuevaTarea) => {
        const tareas = [...this.tareasSubject.value, nuevaTarea];
        this.tareasSubject.next(tareas);
        console.log('Tarea agregada:', nuevaTarea);
      },
      error: (error) => {
        console.error('Error al agregar tarea:', error);
      }
    });
  }

  actualizarTarea(id: number, tareaActualizada: Partial<Tarea>): void {
    this.http.put<Tarea>(`${this.apiUrl}?id=${id}`, tareaActualizada).subscribe({
      next: (tarea) => {
        const tareas = this.tareasSubject.value;
        const index = tareas.findIndex(t => t.id === id);
        
        if (index !== -1) {
          const tareasActualizadas = [...tareas];
          tareasActualizadas[index] = tarea;
          this.tareasSubject.next(tareasActualizadas);
          console.log('Tarea actualizada:', tarea);
        }
      },
      error: (error) => {
        console.error('Error al actualizar tarea:', error);
      }
    });
  }

  eliminarTarea(id: number): void {
    this.http.delete<any>(`${this.apiUrl}?id=${id}`).subscribe({
      next: (response) => {
        const tareas = this.tareasSubject.value.filter(t => t.id !== id);
        this.tareasSubject.next(tareas);
        console.log('Tarea eliminada:', response);
      },
      error: (error) => {
        console.error('Error al eliminar tarea:', error);
      }
    });
  }

  toggleCompletada(id: number): void {
    const tareas = this.tareasSubject.value;
    const tarea = tareas.find(t => t.id === id);
    
    if (tarea) {
      this.actualizarTarea(id, { completada: !tarea.completada });
    }
  }
}
