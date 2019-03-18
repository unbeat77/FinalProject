import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
  
@Component({
  selector: 'app-vendashhome',
  templateUrl: './vendashhome.component.html',
  styleUrls: ['./vendashhome.component.css']
})
export class VendashhomeComponent implements OnInit {
  constructor(private ven :VendorService){}
 vid:string;
 public vendor:Vendor[];
 errormsg:any;
 
  ngOnInit() {
    this.vid=localStorage.getItem('vId');
    console.log(this.vid);
    this.ven.getVendorById(this.vid)
    .subscribe(
      data => {this.vendor = data;
      console.log(data);
      },
      error => this.errormsg= error
    );
  }
}
