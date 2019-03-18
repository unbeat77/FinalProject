import { TestBed , inject } from '@angular/core/testing';

import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { StudentService } from './student.service';
import { Student } from './student';


describe('StudentService', () => {
  let service : StudentService;
  let httpMock :HttpTestingController;
  beforeEach(() => { 
              TestBed.configureTestingModule({
                imports: [
                  HttpClientTestingModule
                ],
                providers:[StudentService]
              });          
              service = TestBed.get(StudentService);
              httpMock = TestBed.get(HttpTestingController);
            });
        
  it('based on paulhalliday video - sample http mocking',()=>{
    const mockstd:Student[] = [
      new Student('12','anand'),
      new Student('51', 'geetha')
    ];
    service.getStudentsHttp().subscribe(
      (data) => {
        expect(data.length).toBe(2);
        expect(data).toEqual(mockstd);
      });
    const request1 = httpMock.expectOne(service.baseUrl);
    expect(request1.request.method).toBe('GET');
    request1.flush(mockstd);

  });
  afterEach(() => { 
    httpMock.verify();
  });
    
});