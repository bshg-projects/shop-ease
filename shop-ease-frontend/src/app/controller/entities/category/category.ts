import { Product } from 'src/app/controller/entities/product/product';
export class Category {
id!: number;
name!: string;
description!: string;
products!: Array<Product>;
}