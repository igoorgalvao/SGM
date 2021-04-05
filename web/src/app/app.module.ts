import { HttpClientModule } from '@angular/common/http';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { environment } from 'src/environments/environment';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { DirectivesModule } from './shared/directives/directives.module';
import { AuthGuard } from './shared/guard/auth.guard';
import { FooterModule } from './shared/template/footer/footer.module';
import { MenuModule } from './shared/template/menu/menu.module';
import { TemplateModule } from './shared/template/template.module';
import { TopBarModule } from './shared/template/topbar/topbar.module';


function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: environment.keycloak.url_keycloack,
        realm: environment.keycloak.realm,
        clientId: environment.keycloak.clientId,
      },
      loadUserProfileAtStartUp: false,
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: true
      },
      bearerExcludedUrls: ['/assets'],
    });
}

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
    DirectivesModule.forRoot(),

    TopBarModule,
    MenuModule,
    FooterModule
  ],
  providers: [
    AuthGuard,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    },
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
