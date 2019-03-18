import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlertdemoComponent } from './alertdemo.component';

describe('AlertdemoComponent', () => {
  let component: AlertdemoComponent;
  let fixture: ComponentFixture<AlertdemoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlertdemoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlertdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
