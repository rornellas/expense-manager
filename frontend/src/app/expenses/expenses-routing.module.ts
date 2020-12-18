import { ExpensesComponent } from './expenses.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

const appRoutes: Routes = [
  { path: '', component: ExpensesComponent }
];

@NgModule({
  imports: [RouterModule.forChild(appRoutes)],
  declarations: []
})
export class ExpensesRoutingModule { }
