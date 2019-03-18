import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HomeComponent } from './home.component';
import { HttpClient } from '@angular/common/http';
import { MenuService } from '../menu.service';
import { of } from 'rxjs';
import { Menu } from '../menu';
import { Router } from '@angular/router';
import { By } from '@angular/platform-browser';
import {  HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('create HomeComponent', () => {
  let httpcli: HttpClient;
  let component: HomeComponent;
  let service: MenuService;
  let router : Router;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HomeComponent],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    service = new MenuService(httpcli);
    component = new HomeComponent(service, router);
  });

  it('should create Home', () => {
    expect(component).toBeTruthy();
  });

  it('should call ngInit with success', () => {
    let menus = [
      new Menu( 1007, 507, 'SAMOSA', 'VEG', 20, 'ALOO SAMOSA'),
      new Menu( 1006, 506, 'CHOCO DONUT', 'VEG', 90, 'CHOClate DONUT')
    ];

    spyOn(service,'getMenu').and.returnValue(of(menus));
    component.ngOnInit();
    expect(component.menus).toEqual(menus);
    expect(component.menus).not.toEqual(null);
  })
})


describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let el: HTMLElement;
  let e2: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeComponent ],
      imports:[HttpClientModule, RouterTestingModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call the vendor details method when vendor login button is clicked ', async() => {
    fixture.detectChanges();
    spyOn(component, 'venlogin');
    el = fixture.debugElement.query( By.css('#vLog')).nativeElement;
    el.click();
    expect(component.venlogin).toHaveBeenCalledTimes(1);
  });

  it('should call the customer details method when customer login button is clicked ', async() => {
    fixture.detectChanges();
    spyOn(component, 'custlogin');
    e2 = fixture.debugElement.query( By.css('#cLog')).nativeElement;
    e2.click();
    expect(component.custlogin).toHaveBeenCalledTimes(1);
  });
})