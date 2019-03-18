import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    let key = 'code';
    localStorage.setItem(key,'5500');
  }

  classesToApply: string = 'italicsClass boldClass';
  applyBoldClass : boolean = true;
  applyItalicsClass : boolean = false;

  addClassess(){
    let classes = {
      boldClass: this.applyBoldClass,
      italicClass: this.applyItalicsClass 
    };
    return classes;
  }

  isBold: boolean = true;
  fontSize: number = 30;
  isItalic: boolean = true;

  addStyles(){
     let styles = {
       'font-weight': this.isBold ? 'bold' : 'normal',
       'font-style': this.isItalic ? 'italic' : 'normal',
       'font-size.px': this.fontSize
     };
     return styles;
    }
}
