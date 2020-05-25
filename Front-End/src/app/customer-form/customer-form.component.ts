

import { CustomerService } from './../service/customer.service';
import { Component, OnInit, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.scss']
})
export class CustomerFormComponent implements OnInit {
  vehicleId: string;
  constructor(public service: CustomerService, private route: ActivatedRoute) {}
  ngOnInit() {
    this.vehicleId = this.route.snapshot.paramMap.get('id');
    console.log(this.vehicleId);
    this.resetForm();
  }
  resetForm(form?: NgForm) {
    if (form != null) {
      form.resetForm();
    }

    this.service.formData = {
      cusName: '',
      cusPhoneNb: null,
      cusEmail: '',
      licenseNumber: '',
      pickUpDate: null,
      dropOffDate: null
    };
  }

  onSubmit(form: NgForm) {
    form.value.id = this.vehicleId;
    this.service.checkavailability(form.value, this.vehicleId).subscribe((res: any) => {
      if(res['status'] === 'unavailable'){
        alert('Vehicle Unavailable');
        this.resetForm(form);
      }else {
        this.service.addCustomerData(form.value, this.vehicleId).subscribe((res: any) => {
          alert('Vehicle Reserved Successfully');
          this.resetForm(form);
          console.log('Successfully entered');
        });
      }
    });
   
  }
}
