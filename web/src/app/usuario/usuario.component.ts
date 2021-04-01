import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from '../shared/model/usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  lista: Usuario[] = [];

  constructor(
    private service: UsuarioService
  ) { }

  ngOnInit(): void {

  }

  consultarPorId() {
    this.service.pesquisarPorId(1).subscribe(retorno => {
      console.log("CONSULTAR: ");
      console.log(retorno);
    }, error => {
      console.log(error);
    });
  }

  listar() {
    this.service.listar().subscribe(retorno => {
      this.lista = retorno;
      console.log("LISTAR: ");
      console.log(this.lista);
    }, error => {
      console.log(error);
    });
  }

  salvar() {
    let usu: Usuario = new Usuario();
    usu.id = 3;
    usu.nome = 'usu3';

    this.service.salvar(usu).subscribe(retorno => {
      console.log("SALVAR: ");
      console.log(retorno);
    }, error => {
      console.log(error);
    });
  }

  alterar() {

    let usu: Usuario = new Usuario();
    usu.id = 3;
    usu.nome = 'usu33333333';

    this.service.salvar(usu).subscribe(retorno => {
      console.log("ALTERAR: ");
      console.log(retorno);
    }, error => {
      console.log(error);
    });
  }

  excluir() {
    this.service.excluir(3).subscribe(retorno => {
      console.log("EXCLUIR SUCESSO ");
    }, error => {
      console.log(error);
    });
  }

}
