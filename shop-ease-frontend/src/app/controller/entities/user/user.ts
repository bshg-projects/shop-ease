import { Order } from 'src/app/controller/entities/user/order';
import { Cart } from 'src/app/controller/entities/user/cart';
import { Address } from 'src/app/controller/entities/transaction/address';
export class User {
id!: number;
phone!: string;
firstName!: string;
lastName!: string;
orders!: Array<Order>;
carts!: Array<Cart>;
address!: Address;
}