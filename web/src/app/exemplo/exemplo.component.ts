import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ExemploService } from '../services/exemplo.service';
import { Exemplo } from '../shared/model/exemplo';

@Component({
  selector: 'app-exemplo',
  templateUrl: './exemplo.component.html',
  styleUrls: ['./exemplo.component.css']
})
export class ExemploComponent implements OnInit {

  lista: Exemplo[] = [];

  constructor(
    private service: ExemploService,
  ) { }

  ngOnInit(): void {

  }

  consultarPorId() {
    this.service.pesquisarPorId(1).subscribe(retorno => {
      console.log("CONSULTAR: ");
      console.log(retorno);
    }, (erro: HttpErrorResponse) => {
      console.log(erro.error.mensagemErro);
    });
  }

  listar() {
    this.service.listar().subscribe(retorno => {
      this.lista = retorno;
      console.log("LISTAR: ");
      console.log(this.lista);
    }, (erro: HttpErrorResponse) => {
      console.log(erro.error.mensagemErro);
    });
  }

  salvar() {
    let usu: Exemplo = new Exemplo();
    usu.id = 3;
    usu.nome = 'usuario3';

    this.service.salvar(usu).subscribe(retorno => {
      console.log("SALVAR: ");
      console.log(retorno);
    }, (erro: HttpErrorResponse) => {
      console.log(erro.error.mensagemErro);
    });
  }

  alterar() {

    let usu: Exemplo = new Exemplo();
    usu.id = 3;
    usu.nome = 'usu33333333';

    this.service.salvar(usu).subscribe(retorno => {
      console.log("ALTERAR: ");
      console.log(retorno);
    }, (erro: HttpErrorResponse) => {
      console.log(erro.error.mensagemErro);
    });
  }

  excluir() {
    this.service.excluir(3).subscribe(retorno => {
      console.log("EXCLUIR SUCESSO ");
    }, (erro: HttpErrorResponse) => {
      console.log(erro.error.mensagemErro);
    });
  }

}
