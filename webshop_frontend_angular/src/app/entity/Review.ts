import { User } from "./User";

export interface Review{
    id: number;
    stars: number;
    title: string;
    text: string;
    user: User;
}