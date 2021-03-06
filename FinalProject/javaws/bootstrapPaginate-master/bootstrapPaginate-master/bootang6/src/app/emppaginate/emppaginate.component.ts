import { Component, OnInit } from '@angular/core';
import { EmployeeService} from '../employee.service';

@Component({
  selector: 'app-emppaginate',
  templateUrl: './emppaginate.component.html',
  styleUrls: ['./emppaginate.component.css']
})
export class EmppaginateComponent implements OnInit {

  employees: any[];
  dispEmps: any[];
  count :number;
  itemperpage:number = 5;
  currentPage=1;
  
    constructor(private empService:EmployeeService ) {
      this.empService=empService;
     }

  ngOnInit() {
    this.employees= this.empService.getEmployees();
    this.count = 15; //this.employees.length;
    console.log("count " , this.count);
    this.dispEmps = this.employees.slice(0, this.itemperpage);
  }

  key: string = 'firstName'; //set default
  reverse: boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
  }

 
  page: number;
 
  pageChanged(event: any): void {
    this.page = event.page;
    event.itemsPerPage = 5;

    const startItem = (event.page - 1) * event.itemsPerPage;
    const endItem = event.page * event.itemsPerPage;
    this.dispEmps = this.employees.slice(startItem, endItem);
  }
}


/**
 

import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/employee.service';
import { Employee } from '../employee';
import { Router } from '@angular/router';
 

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],

})

export class EmployeeComponent implements OnInit {
private details:Employee;
private empId;
private empMgrId;
  constructor(private employeeService:EmployeeService, private router: Router) {
    console.log('Inside the constructor');
    console.log(this);
    this.employeeService = employeeService 
  }
  
  private employees : Employee;
//Sorting
    key: string = 'empId'; //set default
    reverse: boolean = false;
    sort(key){
       this.key = key;
       this.reverse = !this.reverse;
}

  ngOnInit() {
    let empId= sessionStorage.getItem("empId");
    let empMgrId= sessionStorage.getItem("empMgrId");
    console.log('empId');
    console.log('*****************');
    console.log(this.employeeService);
    this.employeeService.getEmployees()
    .subscribe(response=>{
      console.log(response);
      this.details = response.body;
      
    });
  }

  handleClick(empId, empMgrId) {
    sessionStorage.setItem('empId',empId);
    sessionStorage.setItem('empMgrId',empMgrId);
    console.log(empId);
    this.router.navigate(['login',empId]);
  }
  
  }


 */