import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Astronomers} from "../models/astronomer";


@Injectable({
  providedIn: 'root'
})
export class AstronomersService {
  private apiUrl = 'http://localhost:8888/stars/astronomers';

  constructor(private http: HttpClient) { }

  public getAstronomers(): Observable<Astronomers[]> {
    return this.http.get<Astronomers[]>(`${this.apiUrl}`);
  }

  public addStar(star: Astronomers): Observable<Astronomers> {
    return this.http.post<Astronomers>(`${this.apiUrl}/add`,star);
  }
}
