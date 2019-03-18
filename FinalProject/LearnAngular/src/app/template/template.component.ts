import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template',
  template: `
  <p>
    example--  inline style and inline template
  </p> 
  <ng-content></ng-content>
  <p> para goes code is: {{code}}</p>
  `,
  styles: [
  `
  p  { 
    color: blue;
    border : 2 px solid;
   }
  `]
})
export class TemplateComponent implements OnInit {
  code: string;

  constructor() { }

  ngOnInit() {
    let key = 'code';
    this.code = localStorage.getItem(key);
  }

}
