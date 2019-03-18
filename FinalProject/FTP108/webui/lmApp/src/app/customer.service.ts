import { Injectable } from '@angular/core';
import { Customer } from './customer';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Orders } from './orders';

@Injectable(
)
export class CustomerService {
  postUrl = 'http://localhost:8080/FTP108/api/customers/placeorder';
  public static stacustomer: Customer;
  constructor(private httpClient: HttpClient) { }
  validateCustLogin(name: string, password: string): Observable<Customer> {
    console.log('validateLogin');
    const params = new HttpParams()
      .set('cName', name)
      .set('cPassword', password);
    console.log(params.toString());
    return this.httpClient.get<Customer>('http://localhost:8080/FTP108/api/customers', { params });
  }

  getWallet(cid: string): Observable<Customer[]> {
    console.log(cid);
    let walleturl = "http://localhost:8080/FTP108/api/customers/wallet/" + cid;
    return this.httpClient.get<Customer[]>(walleturl);
  }
  getCustById(cid: string): Observable<Customer[]> {
    console.log(cid);
    let cusdetailurl = "http://localhost:8080/FTP108/api/customers/custdetail/" + cid;
    return this.httpClient.get<Customer[]>(cusdetailurl);
  }

  postPlaceOrder(argorders: Orders): Observable<any> {
    let url = 'http://localhost:8080/FTP108/api/customers/placeorder';
    return this.httpClient.post<any>(url, argorders);
  }
}

