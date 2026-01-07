import { Routes } from '@angular/router';
import { ListaTareasComponent } from './components/lista-tareas/lista-tareas';
import { FormularioTareaComponent } from './components/formulario-tarea/formulario-tarea';

export const routes: Routes = [
  { path: '', component: ListaTareasComponent },
  { path: 'nueva', component: FormularioTareaComponent },
  { path: 'editar/:id', component: FormularioTareaComponent },
  { path: '**', redirectTo: '' }
];
