import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-display',
  templateUrl: './customer-display.component.html',
  styleUrls: ['./customer-display.component.css']
})
export class CustomerDisplayComponent implements OnInit {

  customer = {id: 1, name: 'Luis'};
  constructor() { }

  ngOnInit() {
  }

}
