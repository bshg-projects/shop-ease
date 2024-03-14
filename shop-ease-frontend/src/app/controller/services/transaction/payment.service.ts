import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Payment } from 'src/app/controller/entities/transaction/payment';

@Injectable({
    providedIn: 'root'
})
export class PaymentService {
    public readonly api = environment.apiUrl + "payment";
    private _item!: Payment;
    private _items!: Array<Payment>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<Payment>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<Payment>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<Payment>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<Payment>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<Payment>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<Payment>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<Payment>>(`${this.api}/all`, this.items);
    }

    public delete(dto: Payment) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<Payment>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByPaymentMethodId(id: number){
        return this.http.delete<number>(`${this.api}/paymentmethod/${id}`);
    }

    public findByPaymentMethodId(id: number){
        return this.http.get<Payment>(`${this.api}/paymentmethod/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<Payment> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<Payment>) {
        this._items = value;
    }

    public get item(): Payment {
        if (this._item == null)
            this._item = new Payment();
        return this._item;
    }

    public set item(value: Payment) {
        this._item = value;
    }
}

