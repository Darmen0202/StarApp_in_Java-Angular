import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CsrfService {
  constructor(private http: HttpClient) {}

  getCsrfToken(): Observable<string>{
    return this.http.get<string>('http://localhost:8888/auth/csrf-token');
  }
}
