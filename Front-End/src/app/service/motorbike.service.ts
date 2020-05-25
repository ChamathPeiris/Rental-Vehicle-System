import { motorbikeDataList } from '../Models/motorbikeModel';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MotorbikeService {
  apiUrl = 'http://localhost:8080/api/motorbikes';

  constructor(private http: HttpClient) { }

  getMotorbikes(): Observable <motorbikeDataList[]> {
      return this.http.get <motorbikeDataList[]>(this.apiUrl);
  }
}
