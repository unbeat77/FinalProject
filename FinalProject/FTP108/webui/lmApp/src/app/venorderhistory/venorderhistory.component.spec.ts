import { async, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { VenorderhistoryComponent } from './venorderhistory.component';
import { HttpClient } from '@angular/common/http';
import { OrdersService } from '../orders.service';
import { Orders } from '../orders';

describe(' create VenorderhistoryComponent', () => {
  let service: OrdersService;
  let httpClient: HttpClient;
  let component: VenorderhistoryComponent;

  let dateString1 = '2019-01-21 11:00:00'
  let newDate1 = new Date(dateString1);
  let dateString2 = '2019-01-21 11:00:00'
  let newDate2 = new Date(dateString2);
  let dateString3 = '2019-01-21 11:00:00'
  let newDate3 = new Date(dateString3);
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [VenorderhistoryComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    service = new OrdersService(httpClient)
    component = new VenorderhistoryComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should call ngInit with success', () => {
    let ven = [
      new Orders(1, 1, 1001, 1, "thank you", 80, "15:00:00", "11:00:00", newDate1, 501, "DELIVERED"),
      new Orders(2, 7, 1003, 1, " ", 120, "15:00:00", "11:10:00", newDate2, 503, "PLACE_ORDER"),
      new Orders(3, 5, 1001, 3, "good food", 240, "15:00:00", "11:12:00", newDate3, 501, "DELIVERED")
    ];
    localStorage.setItem('vId', '501');
    spyOn(service, 'getVenOrders').and.returnValue(of(ven));
    component.ngOnInit();
    expect(component.orders).toEqual(ven);
    expect(component.orders).not.toEqual(null);
  });
});
