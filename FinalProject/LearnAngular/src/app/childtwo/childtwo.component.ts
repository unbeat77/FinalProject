import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-childtwo',
  templateUrl: './childtwo.component.html',
  styleUrls: ['./childtwo.component.css']
})
export class ChildtwoComponent implements OnInit {

  empCodeInfo: string;
  empParams: string;
  constructor(private _router:Router,
    private _activatedRoute:ActivatedRoute
    ) { }

  ngOnInit() {
    this.empCodeInfo = this._activatedRoute.snapshot.params['name'];
    console.log(this.empCodeInfo);

    this._activatedRoute.paramMap.subscribe(params=> {
      console.log(params.get('name'));
      this.empParams = params.get('name');
    })
  }
}
