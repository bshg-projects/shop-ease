import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Order } from 'src/app/controller/entities/user/order';

@Injectable({
    providedIn: 'root'
})
export class OrderService {
    public readonly api = environment.apiUrl + "order";
    private _item!: Order;
    private _items!: Array<Order>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<Order>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<Order>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<Order>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<Order>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<Order>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<Order>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<Order>>(`${this.api}/all`, this.items);
    }

    public delete(dto: Order) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<Order>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByUserId(id: number){
        return this.http.delete<number>(`${this.api}/user/${id}`);
    }

    public findByUserId(id: number){
        return this.http.get<Array<Order>>(`${this.api}/user/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<Order> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<Order>) {
        this._items = value;
    }

    public get item(): Order {
        if (this._item == null)
            this._item = new Order();
        return this._item;
    }

    public set item(value: Order) {
        this._item = value;
    }
}

