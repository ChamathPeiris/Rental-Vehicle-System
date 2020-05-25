import { Customer } from './../Models/customerModel';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }
  apiUrl = 'http://localhost:8080/api/customer/';
  formData: Customer;

  addCustomerData(cus: Customer, vehicleID: string) {
  return  this.http.post(this.apiUrl + `${vehicleID}`, cus);
  }

  checkavailability(customer: Customer, vehicleID: string) {
    // tslint:disable-next-line: max-line-length
    return this.http.get(`http://localhost:8080/api/check?vehicleID=${vehicleID}&pickup=${customer.pickUpDate}&drop=${customer.dropOffDate}`);
  }
}
