import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExpensesService {

  constructor(private httpClient: HttpClient ) { }

  save(expense: any): Observable<any> {
    return this.httpClient.post(environment.serviceEndpointV1, expense);
  }

  findAll(): Observable<any> {
    return this.httpClient.get(environment.serviceEndpointV1);
  }

  findById(id: number): Observable<any> {
    return this.httpClient.get(environment.serviceEndpointV1.concat(id.toString()));
  }
}
