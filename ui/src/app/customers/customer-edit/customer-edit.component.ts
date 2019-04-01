import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customer = {ud: 1, name: 'Luis'};

  constructor(private router: Router) { }

  ngOnInit() {
  }

  save() {
    console.log("save");
    this.router.navigate(['/customers']);
  }

}
