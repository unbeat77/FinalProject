import { Injectable } from '@angular/core';
import { Menu } from './menu';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable()
export class MenuService {

  MenuURL = "http://localhost:8080/FTP108/api/menu";
  constructor(private httpClient: HttpClient) { }
  getMenu() : Observable<Menu[]> {
    let url = this.MenuURL;
    return this.httpClient.get<Menu[]>(url);
  }
}
