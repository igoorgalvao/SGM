import { Component, OnInit } from '@angular/core';
import { SessaoService } from './services/sessao.service';
import { UsuarioLogado } from './shared/model/usuario-logado';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'sgm-ui';
  menuActive: boolean;

  constructor() {
  }

  ngOnInit(): void {
  }



}


