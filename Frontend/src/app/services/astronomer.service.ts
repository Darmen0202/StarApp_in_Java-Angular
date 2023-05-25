import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { CsrfService } from './csrf.service';
import {Astronomers} from "../models/astronomer";

@Injectable({
  providedIn: 'root'
})
export class AstronomersService {
  private apiUrl = 'http://localhost:8888/stars/astronomers';

  constructor(
    private http: HttpClient,
    private csrfService: CsrfService
  ) { }

  public getAstronomers(): Observable<Astronomers[]> {
    return this.http.get<Astronomers[]>(`${this.apiUrl}`);
  }

  public addAstronomer(astronomers: Astronomers): Observable<Astronomers> {
    const csrfToken = this.csrfService.getCsrfToken();
    const headers = { 'X-CSRF-Token': ''+ csrfToken };
    return this.http.post<Astronomers>(`${this.apiUrl}/add`, astronomers, { headers });
  }
}
