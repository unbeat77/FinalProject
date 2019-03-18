import { Injectable } from '@angular/core';
import { Vendor } from './vendor';
import { Observable } from 'rxjs';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Orders } from './orders';
@Injectable({
  providedIn: 'root'
})
export class VendorService {
  putOStatusUrl = "http://localhost:8080/FTP108/api/vendor/update";

  constructor(private httpClient : HttpClient) { }
   
  validateVenLogin(vname: string, vpass: string): Observable<Vendor>{
    console.log('validateLogin')
      const params = new HttpParams()
      .set('vUsername',vname)
      .set('vPassword',vpass);
      console.log(params.toString());
      return this.httpClient.get<Vendor>("http://localhost:8080/FTP108/api/vendor",{params});
    }
    getVendorById(vid:string) : Observable<Vendor[]>{
      let url ="http://localhost:8080/FTP108/api/vendor/vendetail/" + vid;
      return this.httpClient.get<Vendor[]>(url);
    }

  putOStatusByArgs(ord: Orders): Observable<any> {
      console.log("update order status"+{ord});
    return this.httpClient.put<any>("http://localhost:8080/FTP108/api/vendor/update", ord);
  }

  getGst(vid: string, dt1:string, dt2:string): Observable<any> {
    return this.httpClient.get<any>("http://localhost:8080/FTP108/api/vendor/gst/" + vid + "/" + dt1 + "/" + dt2)
  }
}
