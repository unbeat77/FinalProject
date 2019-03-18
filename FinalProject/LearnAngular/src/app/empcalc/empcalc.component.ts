import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-empcalc',
  templateUrl: './empcalc.component.html',
  styleUrls: ['./empcalc.component.css']
})
export class EmpcalcComponent implements OnInit {
  employees : Employee[];
  public title: Array<{text: string, value : string}> = [
    {text: "Mr", value: "Mr.",},
    {text: "Ms", value: "Ms."}
  ];
  constructor(private _employeeService: EmployeeService) { }

  ngOnInit() {
    this.employees = this._employeeService.getEmployees()
  }



onchangeTitle(vals:any){
  console.log("hi" +vals);
}


  calc(emp:Employee):number{
    let calc : number;
    calc = +(emp.annualSalary)+ +(emp.pf);
    emp.ctc = calc;
    return calc;
  }

  getComment(val : string, emp:Employee) : string{
    return val + emp.name;
  }

}
