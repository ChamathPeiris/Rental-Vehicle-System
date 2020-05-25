import { MotorbikeService } from './../service/motorbike.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-motorbike-list',
  templateUrl: './motorbike-list.component.html',
  styleUrls: ['./motorbike-list.component.scss']
})
export class MotorbikeListComponent implements OnInit {
  public motorbikes = [];

  constructor(private motorbikeService: MotorbikeService) { }

  ngOnInit() {
    return this.motorbikeService.getMotorbikes()
    .subscribe(data => this.motorbikes = data );
  }
  // search vehicles
  Search(searchVal: string) {
    if (searchVal !== '') {
      this.motorbikes = this.motorbikes.filter(res => {
        return res.make.toLocaleLowerCase().match(searchVal.toLocaleLowerCase());
      });
    } else if (searchVal === '') {
      this.ngOnInit();
    }
  }

}
