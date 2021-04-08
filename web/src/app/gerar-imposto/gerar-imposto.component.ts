import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import * as FileSaver from 'file-saver';
import { MessageService, SelectItem } from 'primeng-lts/api';
import { ImpostoService } from '../services/imposto.service';
import { LocalidadeService } from '../services/localidade.service';
import { GerarImposto } from '../shared/model/gerar-imposto';


@Component({
  selector: 'app-gerar-imposto',
  templateUrl: './gerar-imposto.component.html',
  styleUrls: ['./gerar-imposto.component.css']
})
export class GerarImpostoComponent implements OnInit {

  dto: GerarImposto = new GerarImposto();

  tipoPessoa: SelectItem[] = [];

  constructor(
    private service: ImpostoService,
    private localidadeService: LocalidadeService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {

    this.tipoPessoa = [
      { label: 'Física', value: 1 },
      { label: 'Jurídica', value: 2 },
      { label: 'Rural', value: 3 },
    ];

  }

  validarForm() {
    if (!this.dto.cpfCnpj || !this.dto.tipoPessoa || !this.dto.cep || !this.dto.numero) {
      this.messageService.add({ severity: 'warn', summary: 'Atenção', detail: 'Campos obrigatórios não preenchidos.' });
      return false;
    }

    return true;
  }

  gerarImposto() {
    if (!this.validarForm()) {
      return;
    }

    this.service.gerarImpostoPorTipoPessoa(this.dto).subscribe(retorno => {
      const url = window.URL.createObjectURL(retorno.body);
      FileSaver.saveAs(url, this.dto.tipoPessoa == 1 ? "IPTU.pdf" : "ITR.pdf");
    }, (erro: HttpErrorResponse) => {
      this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'IPTU/ITR não localizado' });
    });

  }

  consultarPorCep() {
    if (this.dto.cep && this.dto.cep.length == 9) {
      this.localidadeService.consultaPorCep(this.dto.cep).subscribe(retorno => {
        if (retorno && retorno.logradouro) {
          this.dto.endereco = `${retorno.logradouro} - ${retorno.bairro} , ${retorno.uf} - ${retorno.localidade}`
        } else {
          this.dto.endereco = "Endereço não localizado";
        }
      }, (erro: HttpErrorResponse) => {
        this.dto.endereco = "Endereço não localizado";
        console.log(erro.error.mensagemErro);
      });
    }
  }

  limpar() {
    this.dto = new GerarImposto();
  }


}
