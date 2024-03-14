import { PaymentMethod } from 'src/app/controller/entities/transaction/payment-method';
export class Payment {
id!: number;
paymentDate!: Date;
amount!: number;
paymentMethod!: PaymentMethod;
}