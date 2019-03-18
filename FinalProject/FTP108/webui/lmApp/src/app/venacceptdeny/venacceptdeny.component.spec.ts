import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VenacceptdenyComponent } from './venacceptdeny.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { OrdersService } from '../orders.service';
import { Router } from '@angular/router';

describe('VenacceptdenyComponent', () => {
  let component: VenacceptdenyComponent;
  let fixture: ComponentFixture<VenacceptdenyComponent>;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VenacceptdenyComponent ],
      imports:[HttpClientModule,RouterTestingModule,FormsModule],
      providers:[OrdersService,{ provide: Router, useClass: MockRouter }],
      schemas:[NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  }));
 class MockRouter{ }
  beforeEach(() => {
    fixture = TestBed.createComponent(VenacceptdenyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
