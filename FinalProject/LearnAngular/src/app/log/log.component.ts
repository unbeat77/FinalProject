import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Login } from '../login';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-log',
  templateUrl: './log.component.html',
  styleUrls: ['./log.component.css']
})
export class LogComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;
  stdlogin: Login;

  constructor(private formBuilder: FormBuilder, private ls : LoginService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      uName:['',Validators.required],
    password: ['', [Validators.required, Validators.minLength(2)]]
    });
  }

  get f(){return this.loginForm.controls;}

  onSubmit(){
    this.submitted = true;
    if(this.loginForm.invalid){
      return;
    }
    console.log(this.loginForm.value);
    this.stdlogin = this.loginForm.value;
    if (this.validateLogin()){
      alert('SUCCESS..: ' + this.stdlogin.uName + " " + this.stdlogin.password);
      let key = 'userName';
      localStorage.setItem(key,this.stdlogin.uName);
    } else {
        localStorage.removeItem('userName');}
  }

  validateLogin():boolean{
    let c : Login;
      c = this.ls.validateLogin(this.stdlogin);
      if (c == null)
        return false;
      return true;
  }
}
