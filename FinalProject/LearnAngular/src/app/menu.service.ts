import { Injectable } from '@angular/core';
import { Menu } from './menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  public menuArr : Menu[]
  constructor() {
    this.menuArr = [
      new Menu (1001, 502, 'Panner', 'veg', 120.0, 'Panner roasted on coal' ),
      new Menu (1002, 502, 'Chicken', 'non veg', 250.0, 'Chicken roasted on coal')
    ]
  }
  getMenu(): Menu[] {
    return this.menuArr;
 }
 AddMenu(menu: Menu):void{
   this.menuArr.push(menu);
 }
  getMenuByCode( menucode:number): Menu{
     
    for (let m of this.menuArr){
      let c = m.foodId;
      if ( c  === menucode)
        return m;
    }
   return null;
 } 
}
