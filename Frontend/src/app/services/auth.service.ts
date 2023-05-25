import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, switchMap } from 'rxjs/operators';
import {CsrfService} from "./csrf.service";


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8888/process_login';

  constructor(private http: HttpClient, private csrfService: CsrfService) { }

  login(username: string, password: string): Observable<any> {
    const body = { username, password };

    return this.csrfService.getCsrfToken().pipe(
      switchMap((csrfToken: string) => {
        const headers = new HttpHeaders()
          .set('X-CSRF-TOKEN', csrfToken);

        return this.http.post<any>(this.apiUrl, body, { headers });
      }),
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'An error occurred.';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.error.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

  isAuthenticated() {
    return false;
  }
}
