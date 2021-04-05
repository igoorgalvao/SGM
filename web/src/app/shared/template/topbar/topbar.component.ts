import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { SessaoService } from 'src/app/services/sessao.service';
import { UsuarioLogado } from '../../model/usuario-logado';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopBarComponent implements OnInit {

  public usuarioLogado: UsuarioLogado;

  constructor(
    private router: Router,
    public sessaoService: SessaoService,
  ) { }

  ngOnInit() {
    this.sessaoService.recuperarUsuarioLogado().then(retorno => {
      this.usuarioLogado = retorno;
    }, () => {
      console.log('ERRO');
    });
  }

  toHome() {
    this.router.navigate(['/home']);
  }

  logout() {
    this.sessaoService.sair();
  }

}