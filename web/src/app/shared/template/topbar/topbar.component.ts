import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopBarComponent implements OnInit {

  constructor(
    private router: Router,
    private keycloakService: KeycloakService,
  ) { }

  ngOnInit() { }

  toHome() {
    this.router.navigate(['/home']);
  }

  logout() {
    this.keycloakService.logout();
  }

}