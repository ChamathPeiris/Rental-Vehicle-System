import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { carDataList } from '../Models/carModel';

@Injectable({
  providedIn: 'root'
})
export class CarService {
apiUrl = 'http://localhost:8080/api/cars';

  constructor(private http: HttpClient) { }

  getCars(): Observable<carDataList[]> {
      return this.http.get <carDataList[]>(this.apiUrl);
  }
}
