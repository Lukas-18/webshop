import { ShippingState } from "../enumeration/ShippingState";
import { User } from "./User";
import { PaymentMethod } from "./PaymentMethod";
import { Product } from "./Product";

export interface Order{
    id: number;
    user: User;
    product: Product;
    payment: PaymentMethod;
    paid: boolean;
    shippingState: ShippingState;
    date: Date;
}