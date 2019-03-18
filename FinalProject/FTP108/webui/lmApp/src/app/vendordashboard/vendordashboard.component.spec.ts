import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { VendordashboardComponent } from './vendordashboard.component';
import { Router, ActivatedRoute } from '@angular/router';
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('VendordashboardComponent', () => {
  let component: VendordashboardComponent;
  let fixture: ComponentFixture<VendordashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendordashboardComponent ],
      providers: [{provide: Router, useClass: MockRouter },
                {provide: ActivatedRoute, useValue: {snapshot: { params:({vid:1})}}
                }],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();
  }));
  class MockRouter {
    navigate(){}
  }
  beforeEach(() => {
    fixture = TestBed.createComponent(VendordashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create vendor dash', () => {
    expect(component).toBeTruthy();
  });
});