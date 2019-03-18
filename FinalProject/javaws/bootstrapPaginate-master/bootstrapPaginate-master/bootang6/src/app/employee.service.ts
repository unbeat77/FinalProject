import { Injectable } from '@angular/core';

@Injectable()
export class EmployeeService {

  employees = [ {
    firstName:"Johneee",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Petereee",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"Johnssss",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peterwwww",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"Johnweweww",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peterasasa",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"Johnsdsdsds",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Petersdssqqq",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"Johnxxx",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"Peteryyy",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  },
  {
    firstName:"aaaJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"bbbPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"cccJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"dddPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"eeeJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"fffPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"ggJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"hhhPeter",
    lastName:"Drucker",
    dob:"10-12-1991",
    email:"peter@hexaware.com",
    salary:24000
  }, 
  {
    firstName:"iiiJohn",
    lastName:"Doe",
    dob:"10-10-1990",
    email:"john@hexaware.com",
    salary:20000
   } ,
   {
    firstName:"jjjPeter",
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
