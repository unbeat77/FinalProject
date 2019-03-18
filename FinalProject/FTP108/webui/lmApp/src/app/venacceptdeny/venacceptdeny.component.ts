import { Component, OnInit } from '@angular/core';
import { OrdersService } from '../orders.service';
import { VendorService } from '../vendor.service';
import { Orders } from '../orders';

@Component({
  selector: 'app-venacceptdeny',
  templateUrl: './venacceptdeny.component.html',
  styleUrls: ['./venacceptdeny.component.css'],
  providers: [OrdersService]
})
export class VenacceptdenyComponent implements OnInit {
  public orders: Orders[];
  errormsg: any= "  ";
  successmsg: any = "  ";
  vid: string;
  isputfinished: boolean = false;
  orSt: String;
  constructor(private _ordersservice: OrdersService, private _vendorservice: VendorService) { }

  ngOnInit() {
    this.vid = localStorage.getItem('vId');
    this._ordersservice.getPlacedOrders(this.vid)
      .subscribe(
        data => this.orders = data,
        error => this.errormsg = error
      );
  }

  isChecked(ordId: string, ord: Orders, checked: boolean) {
    ord.checked = checked;
    console.log(' code ' + ordId + ' checked ' + ord.checked);
  }

  updateStatus(ordStatus: string) {
    for (let ord of this.orders) {
      console.log(ord);
      if (ord.checked == true) {
        this.updateOrderStatus(ordStatus, ord.oreason, ord.oid, ord.vid);
      }
    }
  }

  updateOrderStatus(status: string, reason: string, ordId: number, venId: number) {
    console.log(status + "  " + reason + "  " + ordId + "  " + venId);
    let curDate: Date = new Date();
    let o: Orders = new Orders(ordId, 0, 0, 0, reason, 0, "00:00:00", "00:00:00", curDate, venId, status);
    this._vendorservice.putOStatusByArgs(o)
      .subscribe(
        data => {
          console.log("Data " + data.msg);
          this.successmsg += ordId + "  ";
          this.isputfinished = true;
        },
        error => {
          console.log("Error " + error.msg);
          this.errormsg = this.errormsg + error.msg;
          alert(this.errormsg);
        }
      );
      this.orSt = status;
  }

  selectAll() {
    this.orders.forEach((order) => {
      order.checked = true;
    });
  }

  deSelectAll() {
    this.orders.forEach((order) => {
      order.checked = false;
    });
  }
}
