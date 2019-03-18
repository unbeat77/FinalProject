import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-createemp',
  templateUrl: './createemp.component.html',
  styles:[`
  .ng-invalid{
    border: 2px solid: red;
  };
  .ng-valid{
    border: 2px solid: green
  }
  `]
})
export class CreateempComponent implements OnInit {

newEmp : Employee={
  code:"",
  name:"",
  gender:"",
  annualSalary:null,
  dateOfBirth: null,
  pf:0,
  ctc:0,
  title:"",
  comment:""
}
  constructor(private router: Router,
    private employeeService: EmployeeService) { }

  ngOnInit() {
  }

  OnSubmit(form:NgForm){
    console.log(form);
    console.log(this.newEmp);
    this.employeeService.AddEmployees(this.newEmp);
    this.router.navigate(["/home"]);
  }

  dobErr:string;
  checkDob(dateOfBirth : string){
    var db = new Date(this.newEmp.dateOfBirth);
    var curd = new Date();
    curd.setDate(curd.getDate()-1);

    if (db>curd){
      this.dobErr = "error!! DOB greater than today";
      return;
    }
    else{
      this.dobErr="";
  }
}

}
