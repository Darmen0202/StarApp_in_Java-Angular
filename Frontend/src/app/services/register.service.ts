import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CsrfService } from './csrf.service';
import {switchMap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private apiUrl = 'http://localhost:8888/auth/registration';

  constructor(private http: HttpClient, private csrfService: CsrfService) {}

  register(registerData: any) {
    const { username, email, password, csrfToken } = registerData;
    const body = { username, email, password };
    const headers = new HttpHeaders().set('X-CSRF-TOKEN', csrfToken);
    const options = { headers };

    return this.http.post(`${this.apiUrl}`, body, options);
  }
}
