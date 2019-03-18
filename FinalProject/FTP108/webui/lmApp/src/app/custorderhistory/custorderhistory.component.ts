import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../orders.service';
import { Orders } from '../orders';

@Component({
  selector: 'app-custorderhistory',
  templateUrl: './custorderhistory.component.html',
  styleUrls: ['./custorderhistory.component.css'],
  providers:[OrdersService]
})
export class CustorderhistoryComponent implements OnInit {
  public orders : Orders[];
  errormsg : any;
  cid: string;
  constructor(private _ordersservice: OrdersService) { }

  ngOnInit() {
   this.cid=localStorage.getItem('cid');
   console.log("local val" + this.cid);
    this._ordersservice.getCustOrders(this.cid)
    .subscribe(
      data => this.orders = data,
      error => this.errormsg = error
    );
  }
}
