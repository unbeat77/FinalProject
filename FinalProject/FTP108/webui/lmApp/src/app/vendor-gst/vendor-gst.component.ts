import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-vendor-gst',
  templateUrl: './vendor-gst.component.html',
  styleUrls: ['./vendor-gst.component.css']
})
export class VendorGstComponent implements OnInit {
  vid: string;
  vendor: Vendor[]
  gst: any;
  errormsg: any;
  dt1: string;
  dt2: string;
  constructor(private ven: VendorService) { }

  ngOnInit() {
    this.vid = localStorage.getItem('vId');
  }

  getGst(){
    console.log("vid: " + this.vid + "from: " + this.dt1 + "to: "+this.dt2);
    this.ven.getGst(this.vid,this.dt1,this.dt2)
    .subscribe(
      data => {
        this.gst = data;
        console.log(data);
      },
      error => this.errormsg = error
    );
  }

}
