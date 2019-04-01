import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers = [{id: 1, name: 'Luis'}, {id: 2, name: 'Hansel'}]
  constructor() { }

  ngOnInit() {
  }

}
