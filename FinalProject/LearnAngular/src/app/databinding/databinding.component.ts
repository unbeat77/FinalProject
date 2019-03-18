import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  @Input()
  customInputAttr : string;
  stringInterpolation: string;
  numberInterpolation: number;
  fName : string;
  disableflag: boolean;

  
  constructor() { }

  ngOnInit() {
    this.stringInterpolation = "learning basics";
    this.numberInterpolation = 40;
    this.fName = "Abhi";
    this.disableflag = false;
  }

  myalert(){
    alert("Binding Clicked");
  }

  toggle(){
    this.disableflag = this.disableflag?false:true;
  }
}
