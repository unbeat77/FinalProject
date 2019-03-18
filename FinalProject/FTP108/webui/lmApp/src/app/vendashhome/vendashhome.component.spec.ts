import { async, TestBed } from '@angular/core/testing';
import { VendashhomeComponent } from './vendashhome.component';
import { HttpClient } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { Vendor } from '../vendor';
import { of } from 'rxjs';
import { VendorService } from '../vendor.service';
describe('VendashhomeComponent', () => {
  let component: VendashhomeComponent;
  let httpClient : HttpClient;
  let service : VendorService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendashhomeComponent ],
      imports:[RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new VendorService(httpClient);
    component = new VendashhomeComponent(service);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('vendor details by vendor Id',() => {
    let ven = [
      new Vendor(504, 'Dominos', 'Dhru', 'password', 'dhruv@dominos.com','012012012','#345, 6th street,7th phase GK, Bangalore, Karnataka')
    ];
    localStorage.setItem('vId','504');
    spyOn(service, 'getVendorById').and.returnValue( of(ven));
    component.ngOnInit();
    expect(component.vendor).toEqual(ven);
    expect(component.vendor).not.toEqual(null);
  })
});
