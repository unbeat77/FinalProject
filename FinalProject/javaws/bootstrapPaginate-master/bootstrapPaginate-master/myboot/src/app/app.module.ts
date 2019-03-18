import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BsDropdownModule} from 'ngx-bootstrap/dropdown';
import { AlertModule } from 'ngx-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { DropdownComponent } from './dropdown/dropdown.component';
import { AccordionModule  } from 'ngx-bootstrap';
import { ModalexampleComponent } from './modalexample/modalexample.component';
import { DatagridhomeComponent } from './datagridhome/datagridhome.component';
import { EmppaginateComponent } from './emppaginate/emppaginate.component';


import { NgxPaginationModule} from 'ngx-pagination';
import { FilterPipeModule } from 'ngx-filter-pipe';

import {OrderModule } from 'ngx-order-pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import {EmployeeService} from './employee.service';

@NgModule({
  declarations: [
    AppComponent,
    DropdownComponent,
    ModalexampleComponent,
    DatagridhomeComponent,
    EmppaginateComponent 
     
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BsDropdownModule.forRoot(),
    AlertModule.forRoot(),
    AccordionModule.forRoot(),
    NgxPaginationModule,
    FilterPipeModule,
    OrderModule,
    Ng2SearchPipeModule
    
     
  ],
  providers: [
    EmployeeService
  ],
  bootstrap: [AppComponent],
   
})
export class AppModule { }
