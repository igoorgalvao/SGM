import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as FileSaver from 'file-saver';
import { MessageService } from 'primeng-lts/api';
import { Observable } from 'rxjs';
import { GerarImposto } from '../shared/model/gerar-imposto';
import { HttpClientService } from './http-client.service';


@Injectable({
  providedIn: 'root'
})
export class ImpostoService extends HttpClientService {

  constructor(
    protected http: HttpClient) {
    super("imposto");
  }

  gerarImpostoPorTipoPessoa(dto: GerarImposto): Observable<HttpResponse<Blob>> {
    return this.http.post(`${this.baseUrl}/gerarImpostoPorTipoPessoa`, dto, { responseType: 'blob', observe: 'response' });
  }

}
