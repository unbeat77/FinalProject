import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VendorloginComponent } from './vendorlogin/vendorlogin.component';
import { HomeComponent } from './home/home.component';
import { VendordashboardComponent } from './vendordashboard/vendordashboard.component';
import { VenorderhistoryComponent } from './venorderhistory/venorderhistory.component';
import { VenacceptdenyComponent } from './venacceptdeny/venacceptdeny.component';
import { VendashhomeComponent } from './vendashhome/vendashhome.component';
import { CustloginComponent } from './custlogin/custlogin.component';
import { CustdashboardComponent } from './custdashboard/custdashboard.component';
import { CustorderhistoryComponent } from './custorderhistory/custorderhistory.component';
import { CustplaceorderComponent } from './custplaceorder/custplaceorder.component';
import { CustshowwalletComponent } from './custshowwallet/custshowwallet.component';
import { CustdashhomeComponent } from './custdashhome/custdashhome.component';
import { VendorGstComponent } from './vendor-gst/vendor-gst.component';

export const CUSTOMER_ROUTES: Routes = [
  { path: 'custhistory', component: CustorderhistoryComponent },
  { path: 'custplaceorder', component: CustplaceorderComponent },
  { path: 'custshowwallet', component: CustshowwalletComponent },
  { path: 'home', component:CustdashhomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
]

export const VENDOR_ROUTES: Routes = [
  { path: 'venHistory', component: VenorderhistoryComponent },
  { path: 'venacceptdeny', component: VenacceptdenyComponent },
  { path: 'home', component: VendashhomeComponent },
  { path: 'gst', component:VendorGstComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
]

const routes: Routes = [
  { path: 'venDash/:vid', component: VendordashboardComponent, children: VENDOR_ROUTES },
  { path: 'venlogin', component: VendorloginComponent },
  { path: 'custlogin', component: CustloginComponent },
  { path: 'custdash/:cid', component: CustdashboardComponent, children: CUSTOMER_ROUTES },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
