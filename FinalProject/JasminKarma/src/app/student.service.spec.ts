import { TestBed } from '@angular/core/testing';

import { StudentService } from './student.service';
import { Student } from './student';
import { HttpClient } from '@angular/common/http';

describe('StudentService', () => {
  beforeEach(() => TestBed.configureTestingModule({
      providers:[StudentService]
  }));

  it('should be created', () => {
    let httpClient: HttpClient;
    const service: StudentService = new StudentService(httpClient);
    expect(service).toBeTruthy();
  });
});

describe('StudentService create', () => {
  let httpClient : HttpClient
  let stdService: StudentService;
  beforeEach(() => {
    stdService = new StudentService(httpClient);
  })

  afterEach(() => {
    console.log("called after test")
  });

  it('get Student Array', () => {
    let expectstdArr = [
      new Student('101', 'Tom'),
      new Student('102', 'John'),
      new Student('103', 'Peter'),
      new Student('104', 'Mary'),
      new Student('105', 'Lucy'),
    ];

    const stdA = stdService.getStudentArray();
    expect(stdA.length).toBeGreaterThan(2);
    expect(expectstdArr).toEqual(stdA);
  })

  it('Add Student Array', () => {
    let nStd = new Student('1', 'rr');
    stdService.addStudentToArr(nStd);
    expect(stdService.stdArr.length).toBeGreaterThan(2);
    expect(stdService.stdArr).toContain(nStd);
  })

})



