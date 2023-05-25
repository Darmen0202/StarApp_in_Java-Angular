import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Star } from '../models/star';
import { CsrfService } from './csrf.service';

@Injectable({
  providedIn: 'root'
})
export class StarService {
  private apiUrl = 'http://localhost:8888/stars';

  constructor(
    private http: HttpClient,
    private csrfService: CsrfService
  ) { }

  public getStars(): Observable<Star[]> {
    return this.http.get<Star[]>(`${this.apiUrl}`);
  }

  public addStar(star: Star): Observable<Star> {
    const csrfToken = this.csrfService.getCsrfToken();
    const headers = new HttpHeaders({ 'X-CSRF-Token':''+ csrfToken });
    return this.http.post<Star>(`${this.apiUrl}/addNew`, star, { headers });
  }

  public updateStar(star: Star): Observable<Star> {
    const csrfToken = this.csrfService.getCsrfToken();
    const headers = new HttpHeaders({ 'X-CSRF-Token':''+ csrfToken });
    return this.http.put<Star>(`${this.apiUrl}/update`, star, { headers });
  }

  public deleteStar(id: bigint): Observable<Star> {
    const csrfToken = this.csrfService.getCsrfToken();
    const headers = new HttpHeaders({ 'X-CSRF-Token':''+ csrfToken });
    return this.http.delete<Star>(`${this.apiUrl}/delete/${id}`, { headers });
  }
}
