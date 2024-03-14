import {Injectable} from '@angular/core';
import {environment} from "src/environments/environment";
import {HttpClient} from "@angular/common/http";
import {JwtRequest} from "src/app/controller/auth/entities/jwt-request";
import {JwtResponse} from "src/app/controller/auth/entities/jwt-response";

@Injectable({
providedIn: 'root'
})
export class AuthService {

    private _jwtRequest = {} as JwtRequest;
    private url = environment.login

    constructor(private http: HttpClient) { }

    public login() {
        return this.http.post<JwtResponse>(this.url, this.jwtRequest);
    }

    get jwtRequest() {
        if (this._jwtRequest == null)
            this._jwtRequest = new JwtRequest();
        return this._jwtRequest;
    }

    set jwtRequest(val: JwtRequest) {
        this._jwtRequest = val;
    }
}
