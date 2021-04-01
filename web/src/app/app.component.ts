import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'sgm-ui';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private keycloakService: KeycloakService) { }

  logout() {
    this.keycloakService.logout();
  }

}


