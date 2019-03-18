import { Injectable } from '@angular/core';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public empArr : Employee[];
  constructor() {
    this.empArr = [
      new Employee( 'emp101', 'Tom',  'Male',
           5500, '05/14/1988'),
      new Employee( 'emp102', 'John',  'Male',
           6000, '06/12/1988'),
      new Employee( 'emp103', 'Peter',  'Male',
           8000, '05/24/1988'),
      new Employee( 'emp104', 'Mary',  'Female',
           9000, '07/04/1988'),
      new Employee( 'emp105', 'Lucy',  'Female',
           3000, '08/09/1988')
    ];
   }

   getEmployees(): Employee[] {
    return this.empArr;
 }
 AddEmployees(emp: Employee):void{
   this.empArr.push(emp);
 }
  getEmployeeByCode( empcode:string): Employee{
     
    for (let emp of this.empArr){
      let c = emp.code;
      if ( c  === empcode)
        return emp;
    }
   return null;
 } 

}