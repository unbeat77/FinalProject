import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { CustomerService } from './customer.service';
import { Customer } from './customer';
import { Orders } from './orders';
describe('CustomerService', () => {
  let service: CustomerService;
  let httpMock: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CustomerService]
    });
    service = TestBed.get(CustomerService);
    httpMock = TestBed.get(HttpTestingController);
  });

  it('Customer wallet details', () => {
    const wallet: Customer[] = [
      new Customer(1, 'JOHN', 1000, 'JOHN@123', 'JOHN@GMAIL.COM', 432232, 'ASDSASDFS')
    ];
    service.getWallet('1').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(wallet);
      });
    let walleturl = "http://localhost:8080/FTP108/api/customers/wallet/1";
    const request = httpMock.expectOne(walleturl);
    expect(request.request.method).toBe('GET');
    request.flush(wallet);
  });

  it('Customer details', () => {
    const cusdetail: Customer[] = [
      new Customer(1, 'JOHN', 1000, 'JOHN@123', 'JOHN@GMAIL.COM', 432232, 'ASDSASDFS')
    ];
    service.getCustById('1').subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(cusdetail);
      });
    let cusdetailurl = "http://localhost:8080/FTP108/api/customers/custdetail/1"

    const request = httpMock.expectOne(cusdetailurl);
    expect(request.request.method).toBe('GET');
    request.flush(cusdetail);
  });

  it('Customer login ', () => {
    const cuslogin: Customer =
      new Customer(1, 'JOHN', 1000, 'JOHN@123', 'JOHN@GMAIL.COM', 432232, 'ASDSASDFS');
    service.validateCustLogin('JOHN', 'JOHN@123').subscribe(
      (data) => {
        // expect(data.length).toBe(1);
        expect(data).toEqual(cuslogin);
      });
    let cusloginurl = "http://localhost:8080/FTP108/api/customers?cName=JOHN&cPassword=JOHN@123"

    const request = httpMock.expectOne(cusloginurl);
    expect(request.request.method).toBe('GET');
    request.flush(cuslogin);
  });


  afterEach(() => {
    httpMock.verify();
  });
});


describe('CustomerService for placing order', () => {
  let service: CustomerService;
  let httpMock: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers: [CustomerService]
    });
    service = TestBed.get(CustomerService);
    httpMock = TestBed.get(HttpTestingController);
  });
  it('place order to post a new order', () => {
    let dt = new Date(2019, 2, 21, 2, 21, 1);
    const mockOrder: Orders = new Orders(1,1001,5001,2,null,160,"00:00:00","00:00:00",dt,2001,'PLACED_ORDER');
    service.postPlaceOrder(mockOrder).subscribe(
      (data) => {
        console.log(data);
        expect(data).toEqual(mockOrder);
      });
    const request1 = httpMock.expectOne(service.postUrl);
    expect(request1.request.method).toBe('POST');
    request1.flush(mockOrder);

  });
  afterEach(() => {
    httpMock.verify();
  });

});

