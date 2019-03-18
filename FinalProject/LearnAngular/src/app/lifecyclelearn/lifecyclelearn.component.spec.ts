import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LifecyclelearnComponent } from './lifecyclelearn.component';

describe('LifecyclelearnComponent', () => {
  let component: LifecyclelearnComponent;
  let fixture: ComponentFixture<LifecyclelearnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LifecyclelearnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LifecyclelearnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
