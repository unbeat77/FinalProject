import { Injectable } from '@angular/core';

@Injectable()
export class EmployeeService {

  employees = [ {
    firstName:"John",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"John",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"John",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"John",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"John",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }



];
  constructor() { }

  getEmployees(){
    return this.employees;
  }

}
