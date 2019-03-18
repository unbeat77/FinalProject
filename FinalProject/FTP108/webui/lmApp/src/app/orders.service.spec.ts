import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { OrdersService } from './orders.service';
import { Orders } from './orders';

describe('OrdersService', () => {
  let service: OrdersService;
  let httpMock: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers: [OrdersService]
    });
    service = TestBed.get(OrdersService);
    httpMock = TestBed.get(HttpTestingController);
  });

  it('should be created Customer History', () => {
    let OrderDate = "2019-01-21 11:00:00";
    let date = new Date(OrderDate);
    const mockord: Orders[] = [
      new Orders(1, 1, 1001, 1, "null", 80, "15:00:00", "11:00:00", date, 501, "PLACE_ORDER")
    ];

    service.getCustOrders('1').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(mockord);
      });
    let url = "http://localhost:8080/FTP108/api/customers/cushistory/1";
    const request = httpMock.expectOne(url);
    expect(request.request.method).toBe('GET');
    request.flush(mockord);

  });
});

  describe('OrdersService', () => {
    let service: OrdersService;
    let httpMock: HttpTestingController;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        providers: [OrdersService]
      });
      service = TestBed.get(OrdersService);
      httpMock = TestBed.get(HttpTestingController);
    });
    it('mocking the vendororder history', () => {
      let dateString1 = '2019-01-21 11:00:00';
      let newDate1 = new Date(dateString1);
      let dateString2 = '2019-01-21 11:00:00';
      let newDate2 = new Date(dateString2);
      const mockOrd: Orders[] = [
        new Orders(1, 1, 1001, 1, "thank you", 80, "15:00:00", "11:00:00", newDate1, 501, "DELIVERED"),
        new Orders(2, 7, 1003, 1, " ", 120, "15:00:00", "11:10:00", newDate2, 501, "PLACE_ORDER")
      ];
      service.getVenOrders('501').subscribe(
        (data) => {
          expect(data.length).toBe(2);
          expect(data).toEqual(mockOrd);
        });
      let venhisURL = "http://localhost:8080/FTP108/api/vendor/501";
      const venHis = httpMock.expectOne(venhisURL);
      expect(venHis.request.method).toBe('GET');
      venHis.flush(mockOrd);
    });

    it('mocking the place orders', () => {
      let dateString1 = '2019-01-21 11:00:00';
      let newDate1 = new Date(dateString1);
      let dateString2 = '2019-01-21 11:00:00';
      let newDate2 = new Date(dateString2);
      const mockVen: Orders[] = [
        new Orders(1, 1, 1001, 1, "thank you", 80, "15:00:00", "11:00:00", newDate1, 501, "PLACE_ORDER"),
        new Orders(2, 7, 1003, 1, " ", 120, "15:00:00", "11:10:00", newDate2, 501, "PLACE_ORDER")
      ];
      service.getPlacedOrders('501').subscribe(
        (data) => {
          expect(data.length).toBe(2);
          expect(data).toEqual(mockVen);
        });
      let venPlaceorderURL = "http://localhost:8080/FTP108/api/vendor/placedOrders/501";
      const venPlaceorder = httpMock.expectOne(venPlaceorderURL);
      expect(venPlaceorder.request.method).toBe('GET');
      venPlaceorder.flush(mockVen);
    });
  });
