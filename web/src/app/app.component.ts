import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { PrimeNGConfig } from 'primeng-lts/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'sgm-ui';
  menuActive: boolean;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private keycloakService: KeycloakService,
    private primengConfig: PrimeNGConfig
  ) { }

  ngOnInit() {
  }

  logout() {
    this.keycloakService.logout();
  }

}


