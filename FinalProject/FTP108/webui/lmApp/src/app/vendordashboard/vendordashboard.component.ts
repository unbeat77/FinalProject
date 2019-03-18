import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vendordashboard',
  templateUrl: './vendordashboard.component.html',
  styleUrls: ['./vendordashboard.component.css']
})
export class VendordashboardComponent implements OnInit {
   urlVId: any;
  constructor(private router : Router, private ar: ActivatedRoute ) { }
 
  ngOnInit() { this.urlVId = this.ar.snapshot.params['vid'];
  console.log("vId : "+this.urlVId);
  if(this.urlVId==localStorage.getItem('vId')){
     this.router.navigate(['/venDash/',this.urlVId]);
  } else {
    alert("please login again")
    this.router.navigate(['venlogin']);
  }
  }
  gotohome(): void {
    localStorage.removeItem('vId');
    this.router.navigate(['/home']);
    console.log("home page");
  }
  
}
