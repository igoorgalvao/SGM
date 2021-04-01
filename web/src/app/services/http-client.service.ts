import { Inject, Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})

export class HttpClientService {

    protected baseUrl: string;

    constructor(@Inject(String) path: string) {
        this.baseUrl = `${environment.urlbackend}:${environment.port}/${environment.contextPath}${path}`;
    }
}