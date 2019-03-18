import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-employeedetail',
  templateUrl: './employeedetail.component.html',
  styleUrls: ['./employeedetail.component.css']
})
export class EmployeedetailComponent implements OnInit {

  employee: Employee;
  statusMessage: string = "Loading Please Wait";
  constructor(private _employeeService: EmployeeService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute) {
    
  }

  ngOnInit() {
    let empCode:string = this._activatedRoute.snapshot.params['code'];
    this.employee = this._employeeService.getEmployeeByCode(empCode);
  }

  gotoEmployeeList(){
    this._router.navigate(['/home']);
  }

  gotoDashboard(){
    this._router.navigate(['/dashboard'], {queryParams: {code: this.employee.code}})
  }

}
