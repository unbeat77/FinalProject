import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DatagridhomeComponent } from './datagridhome.component';

describe('DatagridhomeComponent', () => {
  let component: DatagridhomeComponent;
  let fixture: ComponentFixture<DatagridhomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DatagridhomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DatagridhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
