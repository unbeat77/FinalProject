import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MenuService } from './menu.service';
import { VendorloginComponent } from './vendorlogin/vendorlogin.component';
import { CustdashboardComponent } from './custdashboard/custdashboard.component';
import { VendordashboardComponent } from './vendordashboard/vendordashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustloginComponent } from './custlogin/custlogin.component';
import { VenorderhistoryComponent } from './venorderhistory/venorderhistory.component';
import { VenacceptdenyComponent } from './venacceptdeny/venacceptdeny.component';
import { VendashhomeComponent } from './vendashhome/vendashhome.component';
import { CustorderhistoryComponent } from './custorderhistory/custorderhistory.component';
import { CustplaceorderComponent } from './custplaceorder/custplaceorder.component';
import { CustshowwalletComponent } from './custshowwallet/custshowwallet.component';
import { CustdashhomeComponent } from './custdashhome/custdashhome.component';
import { VendorGstComponent } from './vendor-gst/vendor-gst.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CustloginComponent,
    VendorloginComponent,
    CustdashboardComponent,
    VendordashboardComponent,
    VenorderhistoryComponent,
    VenacceptdenyComponent,
    VendashhomeComponent,
    CustorderhistoryComponent,
    CustplaceorderComponent,
    CustshowwalletComponent,
    CustdashhomeComponent,
    VendorGstComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [MenuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
