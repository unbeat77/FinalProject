import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpcalcComponent } from './empcalc.component';

describe('EmpcalcComponent', () => {
  let component: EmpcalcComponent;
  let fixture: ComponentFixture<EmpcalcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpcalcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpcalcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
