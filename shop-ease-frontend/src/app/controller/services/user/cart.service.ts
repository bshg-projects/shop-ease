import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Cart } from 'src/app/controller/entities/user/cart';

@Injectable({
    providedIn: 'root'
})
export class CartService {
    public readonly api = environment.apiUrl + "cart";
    private _item!: Cart;
    private _items!: Array<Cart>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<Cart>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<Cart>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<Cart>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<Cart>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<Cart>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<Cart>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<Cart>>(`${this.api}/all`, this.items);
    }

    public delete(dto: Cart) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<Cart>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByUserId(id: number){
        return this.http.delete<number>(`${this.api}/user/${id}`);
    }

    public findByUserId(id: number){
        return this.http.get<Array<Cart>>(`${this.api}/user/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<Cart> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<Cart>) {
        this._items = value;
    }

    public get item(): Cart {
        if (this._item == null)
            this._item = new Cart();
        return this._item;
    }

    public set item(value: Cart) {
        this._item = value;
    }
}

