import { Component, OnInit, ViewChild } from '@angular/core';
import { EmployeeService } from '../employee.service';
import {Employee} from '../employee';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-emplist',
  templateUrl: './emplist.component.html',
  styleUrls: ['./emplist.component.css'],
  
})
export class EmplistComponent implements OnInit {
  displayedColumns = ['code', 'name', 'gender', 'annualSalary', 'dateOfBirth'];
  employees: Employee[];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource: MatTableDataSource<Employee>;

  constructor(private _employeeService : EmployeeService) {
    
    this.employees = this._employeeService.getEmployees();
    // Assign the data to the data source for the table to render
    this.dataSource = new MatTableDataSource(this.employees);
  }

  ngOnInit() {
    let key = 'code';
    localStorage.removeItem(key);
    this.employees = this._employeeService.getEmployees();
  }

  addEmployees(){
    let emp : Employee = new Employee (
      'default', 'default', 'Male', 3000, '08/08/1965'
    );
    this._employeeService.AddEmployees(emp);
  }

}
