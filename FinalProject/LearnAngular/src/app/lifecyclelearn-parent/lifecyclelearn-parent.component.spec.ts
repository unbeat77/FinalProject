import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LifecyclelearnParentComponent } from './lifecyclelearn-parent.component';

describe('LifecyclelearnParentComponent', () => {
  let component: LifecyclelearnParentComponent;
  let fixture: ComponentFixture<LifecyclelearnParentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LifecyclelearnParentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LifecyclelearnParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
