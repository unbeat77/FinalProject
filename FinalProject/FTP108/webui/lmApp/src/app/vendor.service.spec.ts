import { TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { Orders } from './orders';
import { VendorService } from './vendor.service';
import { Vendor } from './vendor';

describe('VendorService', () => {
  let service : VendorService;
  let httpMock : HttpTestingController;
  beforeEach(() => { TestBed.configureTestingModule({
    imports: [HttpClientTestingModule, HttpClientModule],
    providers:[VendorService]
  })
  service = TestBed.get(VendorService);
  httpMock = TestBed.get(HttpTestingController);
});

  it('movking vendor by venId', () => {
    const idven : Vendor[]= [
  new Vendor(502, 'KFC', 'Deepak', 'password', 'deepak@kfc.com','123123123','#123, 4th street,5th phase BTM, Bangalore, Karnataka')
    ]
   service.getVendorById('502').subscribe(
     (data) => {
      expect(data.length).toBe(1);
      expect(data).toEqual(idven);
     })
     
     let venByIdURL = "http://localhost:8080/FTP108/api/vendor/vendetail/502";
     console.log('abcd ' + venByIdURL);
    const venByID = httpMock.expectOne(venByIdURL);
    console.log("hiiii" + venByID);
    expect(venByID.request.method).toBe('GET');
    venByID.flush(idven);
  });

  it('movking vendor login', () => {
    const mocklogin : Vendor= 
  new Vendor(501, 'KFC', 'Deepak', 'password', 'deepak@kfc.com','123123123','#123, 4th street,5th phase BTM, Bangalore, Karnataka')
   service.validateVenLogin('Deepak','password').subscribe(
     (data) => {
      expect(data).toEqual(mocklogin);
     })
     let venloginURL = "http://localhost:8080/FTP108/api/vendor?vUsername=Deepak&vPassword=password";
    const venlogin = httpMock.expectOne(venloginURL);
    expect(venlogin.request.method).toBe('GET');
    venlogin.flush(mocklogin);
  });
});

describe('VendorService for accept and deny', () => {
  let service: VendorService;
  let httpMock: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers: [VendorService]
    });
    service = TestBed.get(VendorService);
    httpMock = TestBed.get(HttpTestingController);
  });
  it('update order status', () => {
    let dt = new Date(2019, 2, 21, 2, 21, 1);
    const ord: Orders = new Orders(1,1001,5001,2,null,160,"00:00:00","00:00:00",dt,2001,'DELIVERED');
    service.putOStatusByArgs(ord).subscribe(
      (data) => {
        console.log(data);
        expect(data).toEqual(ord);
      });
    const request1 = httpMock.expectOne(service.putOStatusUrl);
    expect(request1.request.method).toBe('PUT');
    request1.flush(ord);

  });
  afterEach(() => {
    httpMock.verify();
  });

});
