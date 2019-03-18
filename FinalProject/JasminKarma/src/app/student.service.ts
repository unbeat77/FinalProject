import { Injectable } from '@angular/core';
import { Student } from './student';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class StudentService {
  stdArr: any[];
  
  
  constructor(private httpClient: HttpClient) {
    this.stdArr = [
      new Student('101', 'Tom'),
      new Student('102', 'John'),
      new Student('103', 'Peter'),
      new Student('104', 'Mary'),
      new Student('105', 'Lucy'),
    ];
  }

  public getStudentArray(): Student[] {
    return this.stdArr;
  }

  public addStudentToArr(std: Student): void {
    this.stdArr.push(std);
  }

  public baseUrl = 'http://localhost:8080/StudentRestFul/rest/student';
  public getStudentViaHttp(): any {
    console.log('inside the method getStudentViaHttp');
    const studentsObservable = new Observable(observer => {
      setTimeout(() => {
        observer.next(this.stdArr);
      }, 1000);
    })
    return studentsObservable;
  }

  public getStudentsHttp():Observable<Student[]>{
    console.log("I am here http get");
    let myurl = this.baseUrl;
    return this.httpClient.get<Student[]>(myurl);
  }
}
