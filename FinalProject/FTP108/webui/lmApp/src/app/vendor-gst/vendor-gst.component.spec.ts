import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorGstComponent } from './vendor-gst.component';
import { NO_ERRORS_SCHEMA, DebugElement } from '@angular/core';
import { RouterTestingModule } from '@angular/router/testing';
import { VendorService } from '../vendor.service';
import { of } from 'rxjs';
import { By } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

describe('VendorGstComponent', () => {
  let component: VendorGstComponent;
  let fixture: ComponentFixture<VendorGstComponent>;
  let service: VendorService;
  let de: DebugElement;
  let el: HTMLElement;


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorGstComponent ],
      schemas: [NO_ERRORS_SCHEMA],
      providers:[{ provide: Router, useClass: MockRouter }],
      imports:[RouterTestingModule, HttpClientModule]
    })
    .compileComponents();
  }));
  class MockRouter{}
  beforeEach(() => {
    fixture = TestBed.createComponent(VendorGstComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call the OnSubmit method when submit button is clicked ', async() => {
    fixture.detectChanges();
    spyOn(component, 'getGst');
    el = fixture.debugElement.query ( By.css('#gst')).nativeElement;
    el.click();
    expect(component.getGst).toHaveBeenCalledTimes(1);
  });
});
