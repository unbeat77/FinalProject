import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'],
  providers:[StudentService]
})
export class StudentComponent implements OnInit {

  std : Student[];
  errorMsg : any;
  constructor(private ss:StudentService) {  }

  ngOnInit() {
    this.ss.getStudentViaHttp().subscribe(
      data => {
        console.log('o and f')
        console.log(data);
        this.std = data;
      },
      error => {
        console.log('my' + error);
        this.errorMsg = error;
      }
    );
  }

}
