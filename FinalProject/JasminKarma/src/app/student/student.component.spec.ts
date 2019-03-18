import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentComponent } from './student.component';
import { Observable,of} from 'rxjs';
import { StudentService } from '../student.service';
import { HttpClient } from '@angular/common/http';
import { Student } from '../student';


describe('StudentComponent', () => {
  let httpClient: HttpClient;
  let service: StudentService;
  let component: StudentComponent;

  let fixture: ComponentFixture<StudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    service = new StudentService(httpClient);
    component = new StudentComponent(service);
  });
  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should call ngInit with success', () => {
    let std = [
      new Student ('101', 'Tom'),
      new Student('102', 'John'),
      new Student('103', 'Peter'),
      new Student('104', 'Mary'),
      new Student('105', 'Lucy'),
    ];
    spyOn(service, 'getStudentViaHttp').and.returnValue( of(std));
    component.ngOnInit();
    expect(component.std).toEqual(std);
    expect(component.std).not.toEqual(null);
  });
});
