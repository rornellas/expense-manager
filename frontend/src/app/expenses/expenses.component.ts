import { Observable } from 'rxjs';
import { ExpensesService } from './expenses.service';
import { Component, OnInit, PipeTransform } from '@angular/core';
import { DatePipe, DecimalPipe } from '@angular/common';
import { FormControl } from '@angular/forms';

interface Expense {
  name: string;
  description: string;
  createdAt: Date;
  value: number;
  tags: string;
}

@Component({
  selector: 'app-expenses',
  templateUrl: './expenses.component.html',
  styleUrls: ['./expenses.component.css'],
  providers: [DecimalPipe, DatePipe]
})
export class ExpensesComponent {

  expenses$: Observable<Expense[]>;

  expense!: Expense;

  constructor(pipe: DecimalPipe, private expensesService: ExpensesService) {
    this.expenses$ = this.expensesService.findAll();
  }


}

// function search(text: string, pipe: PipeTransform): Expense[] {
//   return COUNTRIES.filter(country => {
//     const term = text.toLowerCase();
//     return country.name.toLowerCase().includes(term)
//       || pipe.transform(country.description).includes(term)
//       || pipe.transform(country.createdAt).includes(term)
//       || pipe.transform(country.value).includes(term)
//       || pipe.transform(country.tags).includes(term);
//   });
// }
