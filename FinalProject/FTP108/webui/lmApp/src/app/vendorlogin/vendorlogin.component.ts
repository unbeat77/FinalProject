import { Component, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendorlogin',
  templateUrl: './vendorlogin.component.html',
  styleUrls: ['./vendorlogin.component.css'],
  providers: [VendorService]
})
export class VendorloginComponent implements OnInit {


  loginForm: FormGroup;
  submitted = false;
  venlog: Vendor;
  venId: number;



  constructor(private formBuilder: FormBuilder, private ls: VendorService, private router: Router) { }

  ngOnInit() {
    localStorage.removeItem('vId');
    this.loginForm = this.formBuilder.group({
      vusername: ['', Validators.required],
      vpass: ['', [Validators.required, Validators.minLength(2)]]
    });
  }
  get f() { return this.loginForm.controls; }
  errorMsg: string;
  myvendor: Vendor;
  vId:number;

  onSubmit() {
    let vendorlogin: Vendor;
    vendorlogin = this.loginForm.value;
    this.ls.validateVenLogin(vendorlogin.vusername, vendorlogin.vpass).subscribe(
      data => {
        this.myvendor = data;
        this.vId = this.myvendor.vid;
        console.log(data);
        this.gotoVenDashboard(this.vId);
      },
      error => {
        this.errorMsg = error;
        console.log(this.errorMsg);
        alert("Enter Valid Username and Password");
      }
    );
  }
  gotohome(): void {
    this.router.navigate(['/home']);
    console.log("home page");
  }
  gotoVenDashboard(vId : any): void {
    this.router.navigate(['/venDash/', vId]);
    localStorage.setItem('vId',vId);
  }
  
}
