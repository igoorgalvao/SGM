import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exemplo } from '../shared/model/exemplo';
import { HttpClientService } from './http-client.service';


@Injectable({
  providedIn: 'root'
})
export class ExemploService extends HttpClientService {

  constructor(
    protected http: HttpClient) {
    super("exemplo");
  }


  salvar(dto: Exemplo): Observable<Exemplo> {
    return this.http.post<Exemplo>(`${this.baseUrl}/salvar`, dto);
  }

  alterar(dto: Exemplo): Observable<Exemplo> {
    return this.http.put<Exemplo>(`${this.baseUrl}/alterar`, dto);
  }

  excluir(id: number): Observable<Exemplo> {
    return this.http.delete<Exemplo>(`${this.baseUrl}/${id}`);
  }

  listar(): Observable<Exemplo[]> {
    return this.http.get<Exemplo[]>(`${this.baseUrl}/listar`);
  }

  pesquisarPorId(id: number): Observable<Exemplo> {
    return this.http.get<Exemplo>(`${this.baseUrl}/${id}`);
  }

}
