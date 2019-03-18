import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alertdemo',
  templateUrl: './alertdemo.component.html',
  styleUrls: ['./alertdemo.component.css']
})
export class AlertdemoComponent implements OnInit {
  alertflag:boolean;

  constructor() { 

  }

  ngOnInit() {
    this.alertflag= false;
  }

}
