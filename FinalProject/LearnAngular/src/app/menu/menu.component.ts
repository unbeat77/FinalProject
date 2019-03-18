import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { Menu } from '../menu';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
  providers: [MenuService]
})
export class MenuComponent implements OnInit {
  menus : Menu[];
  constructor(private _menuService : MenuService) { }

  ngOnInit() {
    this.menus = this._menuService.getMenu();
  }

}
