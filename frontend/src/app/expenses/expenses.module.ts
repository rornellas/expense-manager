import { RouterModule } from '@angular/router';
import { ExpensesRoutingModule } from './expenses-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExpensesComponent } from './expenses.component';
import { NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    NgbTypeaheadModule,
    ReactiveFormsModule,
    ExpensesRoutingModule
  ],
  declarations: [ExpensesComponent],
  exports: [ExpensesComponent]
})
export class ExpensesModule { }
