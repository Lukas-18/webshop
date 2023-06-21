import { Address } from "./Adress";
import { PaymentMethod } from "./PaymentMethod";
import { ShoppingCart } from "./ShoppingCart";
import { List } from "../utils/List";


export interface User{
    id: number;
    email: string;
    firstname: string;
    surname: string;
    password: string;
    address: Address;
    shoppingCart: ShoppingCart;
    payments: List<PaymentMethod>;
}