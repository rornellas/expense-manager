import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'expenses', pathMatch: 'full' },
  { path: '**', redirectTo: 'expenses' },
  {
    path: 'expenses',
    loadChildren: () => import('./expenses/expenses.module').then(m => m.ExpensesModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
