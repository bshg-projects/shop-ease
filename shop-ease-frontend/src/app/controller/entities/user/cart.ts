import { CartItem } from 'src/app/controller/entities/user/cart-item';
import { User } from 'src/app/controller/entities/user/user';
export class Cart {
id!: number;
status!: boolean;
creationDate!: Date;
cartItem!: Array<CartItem>;
user!: User;
}