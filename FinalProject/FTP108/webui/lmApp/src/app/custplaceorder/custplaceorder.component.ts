import { Component, OnInit} from '@angular/core';
import { Menu } from '../menu';
import { Router } from '@angular/router';
import { MenuService } from '../menu.service';
import { Orders } from '../orders';
import { CustomerService } from '../customer.service';



@Component({
  selector: 'app-custplaceorder',
  templateUrl: './custplaceorder.component.html',
  styleUrls: ['./custplaceorder.component.css'],
  providers: [MenuService, CustomerService],
})
export class CustplaceorderComponent implements OnInit {
  public menus: Menu[];
  errormsg: any;
  ifpost: boolean = false;
  username: string;
  order: Orders;
  f: number;
  c: string;
  q: number;
  foodIds: string = "";
  postmsg: string = "";
  constructor(private _menuservice: MenuService, private _custService: CustomerService) { }

  ngOnInit() {
    this._menuservice.getMenu().subscribe(
      data => this.menus = data,
      error => this.errormsg = error);
  }

  showVegMenu(veg: string) {
    this.menus = [];
    console.log("on change")
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

  isToggle(check: boolean) {
    if (check) {
      this.showVegMenu('VEG');
    } else {
      this.showVegMenu('ALL');
    }
  }

  toggleSelect(menu: Menu, checked: boolean) {
    menu.isSelected = checked;
    console.log('code ' + menu.foodId +
      ' checked ' + checked)
  }

  totPrice(menu: Menu): number {
    if (menu.qty > 0) {
      let totPrice: number = 0;
      if (menu.isSelected == true) {
        totPrice = +(menu.qty * +(menu.foodPrice));
        console.log(totPrice)
        menu.tPrice = totPrice;
      }
      return menu.tPrice;
    }
    return 0;
  }

  insertOrder() {
    let menu: Menu;
    for (menu of this.menus) {
      if (menu.isSelected == true) {
        if (menu.qty > 0) {
          this.f = menu.foodId;
          this.c = localStorage.getItem('cid');
          this.q = menu.qty;
          this.insertOrderByRest(this.c, this.f, this.q);
          this.errormsg = "";
        } else {
          alert("Invalid Food Quantity for food Id : " + menu.foodId);
        }
      }
    }
  }

  insertOrderByRest(custId, foodId, qty) {
    let today: Date = new Date();
    let lst: Array<any>[];
    let o: Orders = new Orders(
      0, custId, foodId, qty, " ", 0, "00:00:00", "00:00:00", today,
      0, "PLACE_ORDER");
    this._custService.postPlaceOrder(o)
      .subscribe(
        data => {
          console.log("Post Request is Successful", data);
          this.postmsg += data.msg + " for Food Id : " + foodId + ' \n';
          this.ifpost = true;
        },
        error => {
          this.errormsg = error;
          console.log("error", error);
          alert(this.errormsg);
        }
      );
  }

  resetAll() {
    this.menus.forEach((menu) => {
      menu.isSelected = false;
    })
  }
}
