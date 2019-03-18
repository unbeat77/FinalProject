import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustdashboardComponent } from './custdashboard.component';
import { ActivatedRoute, Router } from '@angular/router';
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('CustdashboardComponent', () => {
  let component: CustdashboardComponent;
  let fixture: ComponentFixture<CustdashboardComponent>;
  
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustdashboardComponent ],
      providers: [{provide: Router, useClass: MockRouter },
        {provide: ActivatedRoute, useValue: {snapshot: { params:({cid:6})}}
        }],schemas:[NO_ERRORS_SCHEMA]
    })
      .compileComponents();
  }));
   class MockRouter{
     navigate(){}
   }
  beforeEach(() => {
    fixture = TestBed.createComponent(CustdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
