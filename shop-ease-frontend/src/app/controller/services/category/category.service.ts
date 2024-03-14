import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Category } from 'src/app/controller/entities/category/category';

@Injectable({
    providedIn: 'root'
})
export class CategoryService {
    public readonly api = environment.apiUrl + "category";
    private _item!: Category;
    private _items!: Array<Category>;

    constructor(private http: HttpClient) { }

    public findAll() {
        return this.http.get<Array<Category>>(this.api);
    }

    public findById(id: number) {
        return this.http.get<Category>(`${this.api}/id/${id}`);
    }

    public findAllOptimized() {
        return this.http.get<Array<Category>>(`${this.api}/optimized`);
    }

    public create() {
        return this.http.post<Category>(this.api, this.item);
    }

    public createList() {
        return this.http.post<Array<Category>>(`${this.api}/all`, this.items);
    }

    public update() {
        return this.http.put<Category>(this.api, this.item);
    }

    public updateList() {
        return this.http.put<Array<Category>>(`${this.api}/all`, this.items);
    }

    public delete(dto: Category) {
        return this.http.delete<number>(this.api, {body: dto});
    }

    public deleteAll(dtos: Array<Category>) {
        return this.http.delete<number>(this.api, {body: dtos});
    }

    public deleteById(id: number) {
        return this.http.delete<number>(`${this.api}/id/${id}`);
    }


    //------------- getters and setters -----------------------
    public get items(): Array<Category> {
        if (this._items == null)
            this._items = [];
        return this._items;
    }

    public set items(value: Array<Category>) {
        this._items = value;
    }

    public get item(): Category {
        if (this._item == null)
            this._item = new Category();
        return this._item;
    }

    public set item(value: Category) {
        this._item = value;
    }
}

