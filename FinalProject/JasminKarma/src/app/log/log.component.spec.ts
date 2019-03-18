import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms'; // needed
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { Router, ActivatedRoute } from '@angular/router';

import { LogComponent } from './log.component';

describe('LogComponent', () => {
  let component: LogComponent;
  let fixture: ComponentFixture<LogComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogComponent ],
      imports: [ReactiveFormsModule],
      providers: [
        {provide: Router, useClass: MockRouter},
        {provide: ActivatedRoute, 
          useValue:
          {
            snapshot: {
              params: ({
                empId: 'emp101'
              })
            }
          }
        } //mockActiveRouter}
      ]
    })
    .compileComponents();
  }));
  class MockRouter {}
  class MockActiveRouter {
  }
  beforeEach(() => {
    fixture = TestBed.createComponent(LogComponent);
    component = fixture.componentInstance;
    de = fixture.debugElement.query(By.css('form'));
    el = de.nativeElement;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call the OnSubmit method when submit button is clicked ', async() => {
    fixture.detectChanges();
    spyOn(component, 'onSubmit');
    el = fixture.debugElement.query ( By.css('button')).nativeElement;
    el.click();
    expect(component.onSubmit).toHaveBeenCalledTimes(1);
  });
  it('form should be invalid ', async() => {
    component.loginForm.controls['uName'].setValue('');
    component.loginForm.controls['password'].setValue('');
    expect(component.loginForm.valid).toBeFalsy();
  });
  it('form should be valid ', async() => {
    component.loginForm.controls['uName'].setValue('rrrr');
    component.loginForm.controls['password'].setValue('aaaa');
    expect(component.loginForm.valid).toBeTruthy();
  });
});