import { async, TestBed, ComponentFixture } from '@angular/core/testing';
import { CustplaceorderComponent } from './custplaceorder.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MenuService } from '../menu.service';
import { Menu } from '../menu';
import { of } from 'rxjs';
import { CustomerService } from '../customer.service';
import { NO_ERRORS_SCHEMA, DebugElement } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';

describe('create PlaceOrderComponent', () => {
  let httpClient : HttpClient;
  let component : CustplaceorderComponent;
  let _menuservice: MenuService; 
  let _custService: CustomerService;
  let fixture: ComponentFixture<CustplaceorderComponent>;
  let fcomponent : CustplaceorderComponent;
  let el: HTMLElement;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CustplaceorderComponent],
      imports:[FormsModule, ReactiveFormsModule, HttpClientModule, RouterTestingModule],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustplaceorderComponent);
    fcomponent = fixture.componentInstance;
    _menuservice = new MenuService(httpClient);
    component = new CustplaceorderComponent(_menuservice, _custService);
    fixture.detectChanges();
  });

  it('should call ngInit with success', () => {
    let menus = [
      new Menu (1007,507, 'SAMOSA', 'VEG', 20, 'ALOO SAMOSA'),
      new Menu(1006, 506, 'CHOCO DONUT', 'VEG', 90, 'CHOCOLATE DOUNT'),
    ];
    localStorage.setItem('cid', '2');
    spyOn(_menuservice, 'getMenu').and.returnValue( of(menus));
    component.ngOnInit();
    expect(component.menus).toEqual(menus);
    expect(component.menus).not.toEqual(null);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should insert the order  ', async() => {
    fixture.detectChanges();
    spyOn(fcomponent, 'insertOrder');
    el = fixture.debugElement.query ( By.css("#insert")).nativeElement;
    el.click();
    
    expect(fcomponent.insertOrder).toHaveBeenCalledTimes(1);
  });
  it('should cancel th order', async() => {
    fixture.detectChanges();
    spyOn(fcomponent, 'resetAll');
    el = fixture.debugElement.query ( By.css("#cancel")).nativeElement;
    el.click();
    
    expect(fcomponent.resetAll).toHaveBeenCalledTimes(1);
  });
})
