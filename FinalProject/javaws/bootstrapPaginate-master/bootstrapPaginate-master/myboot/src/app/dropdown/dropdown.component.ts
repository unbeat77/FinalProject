import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dropdown',
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.css']
})
export class DropdownComponent implements OnInit {
  menuItems = [
    {
      name: 'menu 1',
      children: ['qwerty', 'foo', 'bar']
    },
    {
      name: 'menu 2',
      children: ['qwerty', 'foo', 'bar']
    },
    {
      name: 'menu 3',
      children: ['qwerty', 'foo', 'bar']
    },
    {
      name: 'menu 4',
      children: ['qwerty', 'foo', 'bar']
    },
    {
      name: 'menu 5',
      children: ['qwerty', 'foo', 'bar']
    }
    ];
    
  constructor() { }

  ngOnInit() {
  }

}
