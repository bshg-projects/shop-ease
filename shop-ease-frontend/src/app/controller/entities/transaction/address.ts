import { User } from 'src/app/controller/entities/user/user';
export class Address {
id!: number;
street!: string;
city!: string;
postalCode!: string;
country!: string;
users!: Array<User>;
}