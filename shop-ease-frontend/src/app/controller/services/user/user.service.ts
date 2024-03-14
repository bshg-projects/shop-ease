import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { User } from 'src/app/controller/entities/user/user';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    public readonly api = environment.apiUrl + "user";
    private _item!: User;
    private _items!: Array<User>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<User>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<User>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<User>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<User>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<User>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<User>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<User>>(`${this.api}/all`, this.items);
    }

    public delete(dto: User) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<User>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByAddressId(id: number){
        return this.http.delete<number>(`${this.api}/address/${id}`);
    }

    public findByAddressId(id: number){
        return this.http.get<Array<User>>(`${this.api}/address/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<User> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<User>) {
        this._items = value;
    }

    public get item(): User {
        if (this._item == null)
            this._item = new User();
        return this._item;
    }

    public set item(value: User) {
        this._item = value;
    }
}

