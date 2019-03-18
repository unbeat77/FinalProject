import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-custdashhome',
  templateUrl: './custdashhome.component.html',
  styleUrls: ['./custdashhome.component.css']
})
export class CustdashhomeComponent implements OnInit {
  public customer : Customer[];
  errormsg : any;
  cid : string ;
  constructor(private _customerservice: CustomerService) { }

  ngOnInit() {
    this.cid = localStorage.getItem('cid');
    this._customerservice.getCustById(this.cid)
    .subscribe(
      data => this.customer = data,
      error => this.errormsg = error
    );

  }
}
