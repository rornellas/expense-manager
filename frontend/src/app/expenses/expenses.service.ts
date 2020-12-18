import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';

// tslint:disable-next-line:variable-name
const URL_v1 = environment.serviceEndpointV1;

@Injectable({
  providedIn: 'root'
})
export class ExpensesService {

  constructor(private httpClient: HttpClient ) { }

  findAll(): Observable<any> {
    return this.httpClient.get(URL_v1);
  }
}
