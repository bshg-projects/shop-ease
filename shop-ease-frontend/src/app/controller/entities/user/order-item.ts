import { Order } from 'src/app/controller/entities/user/order';
import { Product } from 'src/app/controller/entities/product/product';
export class OrderItem {
id!: number;
quantity!: number;
unitPrice!: number;
order!: Order;
product!: Product;
}