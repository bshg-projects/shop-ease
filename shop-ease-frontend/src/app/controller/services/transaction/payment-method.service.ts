import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { PaymentMethod } from 'src/app/controller/entities/transaction/payment-method';

@Injectable({
    providedIn: 'root'
})
export class PaymentMethodService {
    public readonly api = environment.apiUrl + "paymentmethod";
    private _item!: PaymentMethod;
    private _items!: Array<PaymentMethod>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<PaymentMethod>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<PaymentMethod>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<PaymentMethod>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<PaymentMethod>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<PaymentMethod>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<PaymentMethod>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<PaymentMethod>>(`${this.api}/all`, this.items);
    }

    public delete(dto: PaymentMethod) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<PaymentMethod>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }


    //------------- getters and setters -----------------------
    public get items(): Array<PaymentMethod> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<PaymentMethod>) {
        this._items = value;
    }

    public get item(): PaymentMethod {
        if (this._item == null)
            this._item = new PaymentMethod();
        return this._item;
    }

    public set item(value: PaymentMethod) {
        this._item = value;
    }
}

