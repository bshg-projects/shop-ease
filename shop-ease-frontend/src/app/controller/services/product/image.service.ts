import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Image } from 'src/app/controller/entities/product/image';

@Injectable({
    providedIn: 'root'
})
export class ImageService {
    public readonly api = environment.apiUrl + "image";
    private _item!: Image;
    private _items!: Array<Image>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<Image>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<Image>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<Image>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<Image>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<Image>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<Image>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<Image>>(`${this.api}/all`, this.items);
    }

    public delete(dto: Image) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<Image>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }

    public deleteByProductId(id: number){
        return this.http.delete<number>(`${this.api}/product/${id}`);
    }

    public findByProductId(id: number){
        return this.http.get<Array<Image>>(`${this.api}/product/${id}`);
    }

    //------------- getters and setters -----------------------
    public get items(): Array<Image> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<Image>) {
        this._items = value;
    }

    public get item(): Image {
        if (this._item == null)
            this._item = new Image();
        return this._item;
    }

    public set item(value: Image) {
        this._item = value;
    }
}

