import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustdashhomeComponent } from './custdashhome.component';
import { CustomerService } from '../customer.service';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../customer';
import { of } from 'rxjs';
import { NO_ERRORS_SCHEMA } from '@angular/core';



describe('CustdashhomeComponent', () => {
  let httpClient: HttpClient;
  let service: CustomerService;
  let component: CustdashhomeComponent;
  let fixture: ComponentFixture<CustdashhomeComponent>;

 beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustdashhomeComponent ],schemas:[NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new CustomerService(httpClient);
    component = new CustdashhomeComponent(service)
  });

  it('should call nginit with success', () => {
    let cus = [
      new Customer(1,'JOHN',1000,'JOHN@123','JOHN@GMAIL.COM', 432232,'ASDSASDFS'),
    ];
    localStorage.setItem('cid','1')
    spyOn(service,'getCustById').and.returnValue(of(cus));
    component.ngOnInit();
    expect(component.customer).toEqual(cus);
    expect(component.customer).not.toEqual(null);
  });
  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
