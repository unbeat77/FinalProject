import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LearntsComponent } from './learnts/learnts.component';
import { DatabindingComponent } from './databinding/databinding.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmplistComponent } from './emplist/emplist.component';
import { MenuComponent } from './menu/menu.component';
import { TemplateComponent } from './template/template.component';
import { DirectivesComponent } from './directives/directives.component';
import { EmpcalcComponent } from './empcalc/empcalc.component';
import { EmployeedetailComponent } from './employeedetail/employeedetail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChildoneComponent } from './childone/childone.component';
import { ChildtwoComponent } from './childtwo/childtwo.component';
import { CreateempComponent } from './createemp/createemp.component';
import { EmployeeService } from './employee.service';
import { LogComponent } from './log/log.component';
import { LifecyclelearnComponent } from './lifecyclelearn/lifecyclelearn.component';
import { LifecyclelearnParentComponent } from './lifecyclelearn-parent/lifecyclelearn-parent.component';
import { EmployeeTitlePipe } from './employee-title.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatInputModule, MatPaginatorModule, MatProgressSpinnerModule,
  MatSortModule, MatTableModule
} from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    LearntsComponent,
    DatabindingComponent,
    EmplistComponent,
    MenuComponent,
    TemplateComponent,
    DirectivesComponent,
    EmpcalcComponent,
    EmployeedetailComponent,
    DashboardComponent,
    ChildoneComponent,
    ChildtwoComponent,
    CreateempComponent,
    LogComponent,
    LifecyclelearnComponent,
    LifecyclelearnParentComponent,
    EmployeeTitlePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
