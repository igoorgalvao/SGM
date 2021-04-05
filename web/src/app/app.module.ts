import { HttpClientModule } from '@angular/common/http';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { initializer } from 'src/utils/app-init';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { AuthGuard } from './shared/guard/auth.guard';
import { FooterModule } from './shared/template/footer/footer.module';
import { MenuModule } from './shared/template/menu/menu.module';
import { TemplateModule } from './shared/template/template.module';
import { TopBarModule } from './shared/template/topbar/topbar.module';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    TemplateModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,


    TopBarModule,
    MenuModule,
    FooterModule
  ],
  providers: [
    AuthGuard,
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      deps: [KeycloakService],
      multi: true
    }
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
