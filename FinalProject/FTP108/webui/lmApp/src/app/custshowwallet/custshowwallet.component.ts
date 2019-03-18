import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-custshowwallet',
  templateUrl: './custshowwallet.component.html',
  styleUrls: ['./custshowwallet.component.css'],
  providers:[CustomerService]
})
export class CustshowwalletComponent implements OnInit {
  public customer : Customer[];
  errormsg : any;
  cid : string ;
  constructor(private _customerservice: CustomerService) { }

  ngOnInit() {
    this.cid = localStorage.getItem('cid');
    this._customerservice.getWallet(this.cid)
    .subscribe(
      data => this.customer = data,
      error => this.errormsg = error
    );
  }
}
