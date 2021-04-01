import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../shared/model/usuario';
import { HttpClientService } from './http-client.service';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService extends HttpClientService {

  constructor(
    protected http: HttpClient) {
    super("usuario");
  }


  salvar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.baseUrl}/salvar`, usuario);
  }

  alterar(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.baseUrl}/alterar`, usuario);
  }

  excluir(id: number): Observable<Usuario> {
    return this.http.delete<Usuario>(`${this.baseUrl}/${id}`);
  }

  listar(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.baseUrl}/listar`);
  }

  pesquisarPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.baseUrl}/${id}`);
  }

}
