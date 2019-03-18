import { Component, OnInit } from '@angular/core';
import { EmployeeService} from '../employee.service';

@Component({
  selector: 'app-datagridhome',
  templateUrl: './datagridhome.component.html',
  styleUrls: ['./datagridhome.component.css']
})
export class DatagridhomeComponent implements OnInit {

  employees: any[];

  constructor(private empService:EmployeeService ) {
    this.empService=empService;
   }

  ngOnInit() {
    this.employees= this.empService.getEmployees();
  }

}
