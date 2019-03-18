import { Injectable } from '@angular/core';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  logArr: Login[];

  constructor() {
    this.logArr = [
      new Login('100', 'abc'),
      new Login('101','xyz'),
      new Login('102', 'abhi')
    ];
  }
  public validateLogin (arglog:Login): Login{
    console.log(arglog);
    for (let mylog of this.logArr){
      console.log("in array" + mylog.uName + " " + mylog.password);
      let c = mylog.uName;
      if (mylog.uName == arglog.uName && mylog.password == arglog.password){
        console.log("true");
        return mylog;
      }
    }
    return null;
  }
}
