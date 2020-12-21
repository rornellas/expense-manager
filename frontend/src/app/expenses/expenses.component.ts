import { Observable } from 'rxjs';
import { ExpensesService } from './expenses.service';
import { Component, OnDestroy, OnInit, PipeTransform } from '@angular/core';
import { DatePipe, DecimalPipe } from '@angular/common';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

interface Expense {
  id: number;
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

  expenseDetail: any = undefined;

  form: FormGroup;

  constructor(
    pipe: DecimalPipe, private expensesService: ExpensesService,
    private formBuilder: FormBuilder, private modalService: NgbModal
  ) {
    this.expenses$ = this.expensesService.findAll();

    this.form = formBuilder.group( {name: '', description: '', value: '', tags: ''});
  }

  save(expense: Expense): void {
    this.expensesService.save(expense).subscribe(
      result => {
        alert('Register saved successfully!');
        this.expenses$ = this.expensesService.findAll();
      },
      err => {
        alert('Looks like something went wrong!');
      }
    );
  }

  detail(id: number, content: any): void {
    this.expenseDetail = undefined;

    this.expensesService.findById(id).subscribe(
      result => {
        this.expenseDetail = result;
        this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
      },
      err => {
        alert('Looks like something went wrong!');
      }
    );
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
