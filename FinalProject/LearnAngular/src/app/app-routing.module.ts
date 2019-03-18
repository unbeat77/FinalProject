import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmplistComponent } from './emplist/emplist.component';
import { EmployeedetailComponent } from './employeedetail/employeedetail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChildoneComponent } from './childone/childone.component';
import { ChildtwoComponent } from './childtwo/childtwo.component';
import { CreateempComponent } from './createemp/createemp.component';
import { LogComponent } from './log/log.component';
import { LifecyclelearnParentComponent } from './lifecyclelearn-parent/lifecyclelearn-parent.component';

export const CHILD_ROUTES:Routes=[
  {path: 'childone', component:ChildoneComponent},
  {path: 'childtwo/:name', component:ChildtwoComponent}
]

const routes: Routes = [
  {path:'lifecycleparent', component:LifecyclelearnParentComponent},
  {path:'login', component:LogComponent},
  {path: 'dashboard', component:DashboardComponent, children:CHILD_ROUTES},
  {path:'employee/:code', component: EmployeedetailComponent},
  {path:'home', component:EmplistComponent},
  {path:'createemployee', component:CreateempComponent},
  {path:'', redirectTo: '/home', pathMatch:'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
