import { OrderItem } from 'src/app/controller/entities/user/order-item';
import { User } from 'src/app/controller/entities/user/user';
import { OrderStatusEnum } from 'src/app/controller/enums/order-status-enum'
export class Order {
id!: number;
totalAmount!: number;
status!: OrderStatusEnum;
orderDate!: Date;
orderItem!: Array<OrderItem>;
user!: User;
}