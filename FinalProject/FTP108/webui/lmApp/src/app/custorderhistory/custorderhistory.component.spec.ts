import { async, TestBed } from '@angular/core/testing';

import { CustorderhistoryComponent } from './custorderhistory.component';
import { HttpClient } from '@angular/common/http';
import { OrdersService } from '../orders.service';
import { of } from 'rxjs';
import { Orders } from '../orders';

describe('create CustorderhistoryComponent', () => {
  let httpClient: HttpClient;
  let service: OrdersService;
  let component: CustorderhistoryComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CustorderhistoryComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    service = new OrdersService(httpClient);
    component = new CustorderhistoryComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call ngInit with success', () => {
    let OrderDate = "2019-01-21 11:00:00";
    let date = new Date(OrderDate);
    let std = [
      new Orders(1, 1, 1001, 1, "null", 80, "15:00:00", "11:00:00", date, 501, "PLACE_ORDER")
    ];
    localStorage.setItem('cid', '1')
    spyOn(service, 'getCustOrders').and
      .returnValue(of(std));
    component.ngOnInit();
    expect(component.orders).toEqual(std);
    expect(component.orders).not.toEqual(null);
  });

});
