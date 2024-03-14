import { Image } from 'src/app/controller/entities/product/image';
import { CartItem } from 'src/app/controller/entities/user/cart-item';
import { OrderItem } from 'src/app/controller/entities/user/order-item';
import { Category } from 'src/app/controller/entities/category/category';
export class Product {
id!: number;
name!: string;
description!: string;
price!: number;
quantityInStock!: number;
images!: Array<Image>;
cartItem!: Array<CartItem>;
orderItem!: Array<OrderItem>;
category!: Category;
}