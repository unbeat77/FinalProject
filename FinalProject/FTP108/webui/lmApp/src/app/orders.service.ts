import { Injectable } from '@angular/core';
import { Orders } from './orders';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {
  public ordArr: Orders[];
  constructor(private httpClient: HttpClient) {
  }

  getVenOrders(vId: string): Observable<Orders[]> {
    let venhisURL = "http://localhost:8080/FTP108/api/vendor/" + vId;
    return this.httpClient.get<Orders[]>(venhisURL);
  }

  getPlacedOrders(vId: string): Observable<Orders[]> {
    return this.httpClient.get<Orders[]>("http://localhost:8080/FTP108/api/vendor/placedOrders/" + vId);
  }
 
  getCustOrders(cid: string): Observable<Orders[]> {
    console.log(cid);
    let url ="http://localhost:8080/FTP108/api/customers/cushistory/" + cid;
    return this.httpClient.get<Orders[]>(url);
  }

  AddOrders(ord: Orders): void {
    this.ordArr.push(ord);
  }

  getOrdersByCode(ordcode: string): Orders {
    for (let ord of this.ordArr) {
      let c = ord.code;
      if (c === ordcode)
        return ord;
    }
    return null;
  }

 
}
