import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
  export class DashboardComponent implements OnInit {
    empCode: string;
    empCodeSubsc: any;
  
    constructor(
      private _router: Router,
      private _activedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.empCode = this._activedRoute.snapshot.queryParamMap.get("code");
  
    this._activedRoute.queryParamMap.subscribe(params => {
      console.log("vai subscribe" +
      params.get('code'));
      this.empCodeSubsc = params.get('code');
      console.log("vai subscribe emcodesubsc : " + this.empCodeSubsc)
    });
  }

}
