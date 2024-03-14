import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { OrderItem } from 'src/app/controller/entities/user/order-item';

@Injectable({
    providedIn: 'root'
})
export class OrderItemService {
    public readonly api = environment.apiUrl + "orderitem";
    private _item!: OrderItem;
    private _items!: Array<OrderItem>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<OrderItem>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<OrderItem>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<OrderItem>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<OrderItem>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<OrderItem>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<OrderItem>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<OrderItem>>(`${this.api}/all`, this.items);
    }

    public delete(dto: OrderItem) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<OrderItem>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByOrderId(id: number){
        return this.http.delete<number>(`${this.api}/order/${id}`);
    }

    public findByOrderId(id: number){
        return this.http.get<Array<OrderItem>>(`${this.api}/order/${id}`);
    }
    public deleteByProductId(id: number){
        return this.http.delete<number>(`${this.api}/product/${id}`);
    }

    public findByProductId(id: number){
        return this.http.get<Array<OrderItem>>(`${this.api}/product/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<OrderItem> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<OrderItem>) {
        this._items = value;
    }

    public get item(): OrderItem {
        if (this._item == null)
            this._item = new OrderItem();
        return this._item;
    }

    public set item(value: OrderItem) {
        this._item = value;
    }
}

