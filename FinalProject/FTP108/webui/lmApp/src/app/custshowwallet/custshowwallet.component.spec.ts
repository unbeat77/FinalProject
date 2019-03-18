import { async, TestBed } from '@angular/core/testing';
import { CustshowwalletComponent } from './custshowwallet.component';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';

describe('Create CustshowwalletComponent', () => {
  let httpClient: HttpClient;
  let service: CustomerService;
  let component: CustshowwalletComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CustshowwalletComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    service = new CustomerService(httpClient);
    component = new CustshowwalletComponent(service)
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call nginit with success', () => {
    let cus = [
      new Customer(1,'JOHN',1000,'JOHN@123','JOHN@GMAIL.COM', 432232,'ASDSASDFS'),
    ];
    localStorage.setItem('cid','1')
    spyOn(service,'getWallet').and.returnValue(of(cus));
    component.ngOnInit();
    expect(component.customer).toEqual(cus);
    expect(component.customer).not.toEqual(null);
  });

});
