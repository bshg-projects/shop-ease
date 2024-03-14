import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Address } from 'src/app/controller/entities/transaction/address';

@Injectable({
    providedIn: 'root'
})
export class AddressService {
    public readonly api = environment.apiUrl + "address";
    private _item!: Address;
    private _items!: Array<Address>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<Address>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<Address>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<Address>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<Address>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<Address>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<Address>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<Address>>(`${this.api}/all`, this.items);
    }

    public delete(dto: Address) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<Address>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }


    //------------- getters and setters -----------------------
    public get items(): Array<Address> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<Address>) {
        this._items = value;
    }

    public get item(): Address {
        if (this._item == null)
            this._item = new Address();
        return this._item;
    }

    public set item(value: Address) {
        this._item = value;
    }
}

