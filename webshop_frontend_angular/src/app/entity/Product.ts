import { Availability } from "../enumeration/Availability";
import { Category } from "../enumeration/Category";
import { List } from "../utils/List";
import { Review } from "./Review";

export interface Product{
    id: number;
    name: string;
    description: string;
    price: number;
    salePrice: number;
    sale: boolean;
    category: Category;
    reviews: List<Review>;
    availability: Availability;
    imageSource: string;
}