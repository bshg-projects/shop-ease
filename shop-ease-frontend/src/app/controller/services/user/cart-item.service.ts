import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { CartItem } from 'src/app/controller/entities/user/cart-item';

@Injectable({
    providedIn: 'root'
})
export class CartItemService {
    public readonly api = environment.apiUrl + "cartitem";
    private _item!: CartItem;
    private _items!: Array<CartItem>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<CartItem>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<CartItem>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<CartItem>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<CartItem>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<CartItem>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<CartItem>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<CartItem>>(`${this.api}/all`, this.items);
    }

    public delete(dto: CartItem) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<CartItem>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByCartId(id: number){
        return this.http.delete<number>(`${this.api}/cart/${id}`);
    }

    public findByCartId(id: number){
        return this.http.get<Array<CartItem>>(`${this.api}/cart/${id}`);
    }
    public deleteByProductId(id: number){
        return this.http.delete<number>(`${this.api}/product/${id}`);
    }

    public findByProductId(id: number){
        return this.http.get<Array<CartItem>>(`${this.api}/product/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<CartItem> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<CartItem>) {
        this._items = value;
    }

    public get item(): CartItem {
        if (this._item == null)
            this._item = new CartItem();
        return this._item;
    }

    public set item(value: CartItem) {
        this._item = value;
    }
}

