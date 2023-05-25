import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Star} from "../models/star";


@Injectable({
  providedIn: 'root'
})
export class StarService {
  private apiUrl = 'http://localhost:8888/stars';

  constructor(private http: HttpClient) { }

  public getStars(): Observable<Star[]> {
    return this.http.get<Star[]>(`${this.apiUrl}`);
  }

  public addStar(star: Star): Observable<Star> {
    return this.http.post<Star>(`${this.apiUrl}/addNew`,star);
  }

  public updateStar(star: Star): Observable<Star> {
    return this.http.put<Star>(`${this.apiUrl}/update`, star);
  }

  public deleteStar(id: bigint): Observable<Star> {

    return this.http.delete<Star>(`${this.apiUrl}/delete/{id}`);
  }
}
