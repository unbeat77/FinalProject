import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { EmppaginateComponent } from './emppaginate/emppaginate.component';

import { NgxPaginationModule} from 'ngx-pagination'; 
import { FilterPipeModule } from 'ngx-filter-pipe'; 

import {OrderModule } from 'ngx-order-pipe'; 
import { Ng2SearchPipeModule } from 'ng2-search-filter';   

import {EmployeeService} from './employee.service';

@NgModule({
  declarations: [
    AppComponent,
    EmppaginateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgxPaginationModule,
    FilterPipeModule,
    OrderModule,
    Ng2SearchPipeModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
