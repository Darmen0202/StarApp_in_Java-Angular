import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {CsrfService} from "../../services/csrf.service";

@Component({
  selector: 'app-login',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent {
  private apiUrl = 'http://localhost:8888';
  username: string = '';
  password: string = '';

  constructor(private http: HttpClient, private csrfService: CsrfService) {}

  login(): void {

    this.csrfService.getCsrfToken().subscribe((csrfToken: string) => {
      console.log('CSRF Token:', csrfToken); // Проверка значения csrfToken
      const loginData = { username: this.username, password: this.password };

      const headers = new HttpHeaders()
        .set('Content-Type', 'application/json')
        .set('X-CSRF-TOKEN', csrfToken);
      const options = { headers: headers };

      this.http.post(`${this.apiUrl}/process_login`, loginData, options).subscribe(
        (response) => {
          console.log('Login successful:', response);
        },
        (error) => {
          console.error('Login error:', error);
        }
      );
    });
  }
}
