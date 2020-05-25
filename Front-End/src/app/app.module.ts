import { MotorbikeService } from './service/motorbike.service';
import { CustomerService } from './service/customer.service';
import { CarService } from './service/car.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';



import {FormsModule} from '@angular/forms';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { from } from 'rxjs';
import { MotorbikeListComponent } from './motorbike-list/motorbike-list.component';
import { MatDialogModule } from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    VehicleListComponent,
    CustomerFormComponent,
    MotorbikeListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [CarService, MotorbikeService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
