import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employees = [ {
    firstName:"aJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"bPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"cJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"dPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"eJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"fPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"gJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"hPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"IJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"jPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  } ];
  constructor() { }
  getEmployees(){
    return this.employees;
  }
}
