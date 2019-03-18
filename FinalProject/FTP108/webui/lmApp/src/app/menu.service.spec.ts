import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { MenuService } from './menu.service';
import { Menu } from './menu';

describe('MenuService', () => {
  let service : MenuService;
  let httpMock :HttpTestingController;
  beforeEach(() => {
              TestBed.configureTestingModule({
                imports: [
                  HttpClientTestingModule
                ],
                providers:[MenuService]
              });          
              service = TestBed.get(MenuService);
              httpMock = TestBed.get(HttpTestingController);
            });

  it('should be created',()=>{

    const mockord:Menu[] = [
      new Menu(1001,501,"CHICKENWINGS","NONVEG",80,"CRISPY DEEP FRIED CHICKEN")
    ];
    
    service.getMenu().subscribe(
      (data) => {
        expect(data.length).toBe(1);
        expect(data).toEqual(mockord);
      });
      let url ="http://localhost:8080/FTP108/api/menu";
    const request = httpMock.expectOne(url);
    expect(request.request.method).toBe('GET');
    request.flush(mockord);

  });


  afterEach(() => { 
    httpMock.verify();
  });

});



