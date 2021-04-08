import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Endereco } from '../shared/model/endereco';
import { Exemplo } from '../shared/model/exemplo';
import { HttpClientService } from './http-client.service';


@Injectable({
  providedIn: 'root'
})
export class LocalidadeService extends HttpClientService {

  constructor(
    protected http: HttpClient) {
    super("localidade");
  }

  consultaPorCep(cep: string): Observable<Endereco> {
    return this.http.get<Endereco>(`${this.baseUrl}/consultaPorCep/${cep}`);
  }

}
