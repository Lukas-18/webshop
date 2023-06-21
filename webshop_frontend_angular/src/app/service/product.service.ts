import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../entity/Product';

@Injectable({
    providedIn: 'root'
})
export class ProductService {
    private apiServerUrl = 'http://localhost:8080';

    constructor(private http: HttpClient) { }

    public getAllProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(`${this.apiServerUrl}/webshop_product/all`);
    }

    public getProductById(id: number): Observable<Product> {
        return this.http.get<Product>(`${this.apiServerUrl}/webshop_product/${id}`);
    }

    public createProduct(product: Product): Observable<Product> {
        return this.http.post<Product>(`${this.apiServerUrl}/webshop_product/create`, product);
    }

    public updateProduct(product: Product): Observable<Product> {
        return this.http.put<Product>(`${this.apiServerUrl}/webshop_product/update`, product);
    }

    public deleteProduct(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/webshop_product/delete/${id}`);
    }
}