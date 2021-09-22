import { Inject, Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})

export class HttpClientService {

    protected baseUrl: string;

    constructor(@Inject(String) path: string) {
        if(environment.useheroky){
            this.baseUrl = `${environment.urlbackendheroku}/${environment.contextPath}${path}`;
        }else{
            this.baseUrl = `${environment.urlbackend}:${environment.port}/${environment.contextPath}${path}`;
        }
    }
}