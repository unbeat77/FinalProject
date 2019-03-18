import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LearntsComponent } from './learnts.component';

describe('LearntsComponent', () => {
  let component: LearntsComponent;
  let fixture: ComponentFixture<LearntsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LearntsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LearntsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
