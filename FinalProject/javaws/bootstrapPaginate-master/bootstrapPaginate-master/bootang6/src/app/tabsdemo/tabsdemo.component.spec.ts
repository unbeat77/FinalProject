import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabsdemoComponent } from './tabsdemo.component';

describe('TabsdemoComponent', () => {
  let component: TabsdemoComponent;
  let fixture: ComponentFixture<TabsdemoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabsdemoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabsdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
