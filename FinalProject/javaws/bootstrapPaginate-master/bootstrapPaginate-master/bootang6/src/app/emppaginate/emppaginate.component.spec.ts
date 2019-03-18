import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmppaginateComponent } from './emppaginate.component';

describe('EmppaginateComponent', () => {
  let component: EmppaginateComponent;
  let fixture: ComponentFixture<EmppaginateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmppaginateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmppaginateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
