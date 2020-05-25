import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CustomerFormComponent} from './customer-form/customer-form.component';
import { MotorbikeListComponent } from './motorbike-list/motorbike-list.component';



const routes: Routes = [
  {path : '', component: HomeComponent},
  {path : 'vehicleList', component: VehicleListComponent},
  {path : 'customer/:id', component: CustomerFormComponent},
  {path : 'motorbikeList', component: MotorbikeListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
