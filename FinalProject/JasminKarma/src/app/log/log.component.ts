// .ts
import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Login } from '../login';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Observable} from 'rxjs';
 
@Component({
  selector: 'app-log',
  templateUrl: './log.component.html',
  styleUrls: ['./log.component.css']
})
export class LogComponent implements OnInit {
  errorMessage : string;
  loginForm: FormGroup;
  submitted = false;
  stdlogin : Login;

  constructor(private formBuilder: FormBuilder,
     ) { }
  ngOnInit() {
      this.loginForm = this.formBuilder.group({
        uName: ['', Validators.required],
        password: ['', [Validators.required, Validators.minLength(2)]]
      });
  }
    // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }
  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    //console.log(this.loginForm);
    console.log(this.loginForm.value);
    this.stdlogin = this.loginForm.value;
    if ( this.confirmLogin() )
     alert('SUCCESS!!'  + this.stdlogin.uName + " "+ 
              this.stdlogin.password);
    else
      alert('error');
   
    }   
    confirmLogin():boolean{
        let std : Student;

        let flag : boolean = true;
        this.errorMessage = '';
        /*
        this.ss.verifyPassword(this.stdlogin)
        .subscribe(data => {
          console.log(data);
          flag = true;
          return flag;
        });
        */
     return flag;
    }
    
}
/*
this.ss.verifyPassword(this.stdlogin)
            .subscribe(
              (data : Student ) => {
                this.stdRecd = data;
                console.log("from backend "+ this.stdRecd);
              },
              (error) => {          
                this.errorMessage = error.message; 
                this.loading = false; 
                        },
              () => {this.loading = false;})
*/
