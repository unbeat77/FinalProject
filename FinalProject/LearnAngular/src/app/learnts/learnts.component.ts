import { Component, OnInit } from '@angular/core';
import { Food } from '../food';

@Component({
  selector: 'app-learnts',
  templateUrl: './learnts.component.html',
  styleUrls: ['./learnts.component.css']
})
export class LearntsComponent implements OnInit {

  constructor() { }

  private ice_cream = {fName:"cone-ice", fCalories:200};
  private northIndian = new Food("chapati\t", 10, "\tVeg");
  ngOnInit() {
    let str : string;
    str = "Hi ts";
    console.log(str);
    let num : number;
    num = 5;
    console.log(num);
    let aBoolean : boolean;
    aBoolean = false;
    console.log(aBoolean);
    let anyDt : any;
    anyDt = 100;
    console.log(anyDt);

    console.log("Name\t" + this.ice_cream.fName);
    console.log("Calories\t" + this.ice_cream.fCalories);
    this.northIndian.displayAll();
  }

}
