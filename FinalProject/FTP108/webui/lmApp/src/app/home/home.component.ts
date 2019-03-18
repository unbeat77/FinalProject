import { Component, OnInit } from '@angular/core';
import { Menu } from '../menu';
import { Router } from '@angular/router';
import { MenuService } from '../menu.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [MenuService]
})
export class HomeComponent implements OnInit {
  public menus: Menu[] = [];
  errormsg: any;
  username: string;
  vegOnly: boolean = false;

  constructor(private _menuservice: MenuService, private router: Router) { }

  ngOnInit() {
    localStorage.removeItem('cid');
    localStorage.removeItem('vId');
    this._menuservice.getMenu().subscribe(
      data => this.menus = data,
      error => this.errormsg = error
    );
  }

  showVegMenu(veg: string) {
    this.menus = [];
    this._menuservice.getMenu().subscribe(
      data => {
        if (veg == 'VEG') {
          for (let men of data) {
            if (men.foodCategory == 'VEG') {
              this.menus.push(men);
            }
          }
        } else {
          this.menus = data;
        }
      },
      error => this.errormsg = error
    );
  }

  venlogin() {
    this.router.navigate(['/venlogin']);
  }

  custlogin() {
    this.router.navigate(['/custlogin']);
  }

  isToggle(check: boolean) {
    if(check) {
      this.showVegMenu('VEG');
    } else {
      this.showVegMenu('ALL');
    }
  }
}
