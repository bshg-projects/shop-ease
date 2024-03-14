import { Cart } from 'src/app/controller/entities/user/cart';
import { Product } from 'src/app/controller/entities/product/product';
export class CartItem {
id!: number;
quantity!: number;
cart!: Cart;
product!: Product;
}