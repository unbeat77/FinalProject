import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { AlertModule } from 'ngx-bootstrap/alert';
import { TabsModule } from 'ngx-bootstrap/tabs';
//import {OrderModule } from 'ngx-order-pipe';
//import { FilterPipeModule } from 'ngx-filter-pipe';


import { AppComponent } from './app.component';
import { EmppaginateComponent } from './emppaginate/emppaginate.component';
import {EmployeeService} from './employee.service';
import { AlertdemoComponent } from './alertdemo/alertdemo.component';
import { TabsdemoComponent } from './tabsdemo/tabsdemo.component';

@NgModule({
  declarations: [
    AppComponent,
    EmppaginateComponent,
    AlertdemoComponent,
    TabsdemoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BsDropdownModule.forRoot(),
    PaginationModule.forRoot(),
    AlertModule.forRoot(),
    TabsModule.forRoot()
  ],
  providers: [
    EmployeeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
