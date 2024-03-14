import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Product } from 'src/app/controller/entities/product/product';

@Injectable({
    providedIn: 'root'
})
export class ProductService {
    public readonly api = environment.apiUrl + "product";
    private _item!: Product;
    private _items!: Array<Product>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<Product>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<Product>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<Product>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<Product>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<Product>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<Product>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<Product>>(`${this.api}/all`, this.items);
    }

    public delete(dto: Product) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<Product>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByCategoryId(id: number){
        return this.http.delete<number>(`${this.api}/category/${id}`);
    }

    public findByCategoryId(id: number){
        return this.http.get<Array<Product>>(`${this.api}/category/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<Product> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<Product>) {
        this._items = value;
    }

    public get item(): Product {
        if (this._item == null)
            this._item = new Product();
        return this._item;
    }

    public set item(value: Product) {
        this._item = value;
    }
}

