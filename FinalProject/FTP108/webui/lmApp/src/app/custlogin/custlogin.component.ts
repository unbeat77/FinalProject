import { Component, OnInit, ɵConsole } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-custlogin',
  templateUrl: './custlogin.component.html',
  styleUrls: ['./custlogin.component.css'],
})
export class CustloginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private ls: CustomerService,
    private router: Router) { }
  errorMsg: string;
  myCustomer: Customer;
  cusId: number;
  loaded: boolean = false;
  onSubmit() {
    let cuslogin: Customer;
    cuslogin = this.loginForm.value;
    this.ls.validateCustLogin(cuslogin.cname, cuslogin.cpassword)
      .subscribe(
      data=>{
        this.loaded=true;
        this.myCustomer=data;
        console.log(data);
        console.log(this.myCustomer.cname);
        this.cusId=this.myCustomer.cid
         this.gotocustdashboard(this.cusId);
        //setitinlocalstorage
        ///rotuernavigatetocustomerboard.
      },
      error=> {
        this.errorMsg=error;
        console.log("E"+this.errorMsg)
        alert("Incorrect username or password")
      }
    );
  }

  ngOnInit() {
    localStorage.removeItem('cid');
    this.loginForm = this.formBuilder.group({
      cname: ['', Validators.required],
      cpassword: ['', [Validators.required, Validators.minLength(5)]]
    });
  }
  get f() { return this.loginForm.controls; }
  gotohome(): void {
    this.router.navigate(['/home'])
    console.log("Home");
  }

  gotocustdashboard(cId: any): void {
    this.router.navigate(['/custdash/', cId])
    localStorage.setItem('cid', cId);
    console.log(cId);
  }
}

