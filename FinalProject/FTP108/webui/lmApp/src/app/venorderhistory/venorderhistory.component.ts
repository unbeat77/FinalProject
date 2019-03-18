import { Component, OnInit } from '@angular/core';
import { Orders } from '../orders';
import { OrdersService } from '../orders.service';

@Component({
  selector: 'app-venorderhistory',
  templateUrl: './venorderhistory.component.html',
  styleUrls: ['./venorderhistory.component.css']
})
export class VenorderhistoryComponent implements OnInit {
  public orders: Orders[];
  errormsg : any;
  vid: string;
  constructor(private _ordersservice: OrdersService) { }

  ngOnInit() {
    this.vid = localStorage.getItem('vId');
    this._ordersservice.getVenOrders(this.vid)
    .subscribe(
      data => this.orders = data,
      error => this.errormsg = error
    );
  }
}
