// import { carModel } from '@angular-devkit/build-angular';
import { carDataList } from './../Models/carModel';
import { CarService } from '../service/car.service';
import { Component, OnInit } from '@angular/core';
// import {carModel} from '../Models/carModel';


@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit {
 public cars = [];
 public carDataList;
 searchInput: string;
  // tslint:disable-next-line: no-shadowed-variable
  constructor(private carService: CarService) { }

  ngOnInit() {
     return this.carService.getCars()
    .subscribe(data => this.cars = data );
  }
// search vehicles
  Search(searchVal: string) {
    if (searchVal !== '') {
      this.cars = this.cars.filter(res => {
        return res.make.toLocaleLowerCase().match(searchVal.toLocaleLowerCase());
      });
    } else if (searchVal === '') {
      this.ngOnInit();
    }
  }

}
