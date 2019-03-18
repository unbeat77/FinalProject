import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-custdashboard',
  templateUrl: './custdashboard.component.html',
  styleUrls: ['./custdashboard.component.css']
})
export class CustdashboardComponent implements OnInit {
  urlCId: any;
  constructor(private router: Router, private ar: ActivatedRoute) { }

  ngOnInit() {
  this.urlCId = this.ar.snapshot.params['cid'];
    console.log("cId : " + this.urlCId);
    if (this.urlCId == localStorage.getItem('cid')) {
      this.router.navigate(['/custdash/', this.urlCId]);
    } else {
      alert("please login again")
      this.router.navigate(['custlogin']);
    }
  }
  gotohome(): void {
    localStorage.removeItem('cid')
    this.router.navigate(['/home'])
    console.log("Home");
    console.log(localStorage.getItem('cid'))
  }
}
