package alz.genfive.webshop.service;

import alz.genfive.webshop.entity.Product;
import alz.genfive.webshop.exception.ProductNotFoundException;
import alz.genfive.webshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product createProduct(Product product){
        return this.productRepo.save(product);
    }

    public List<Product> findAllProducts(){
        return this.productRepo.findAll();
    }

    public Product findProductById(Long id){
        return this.productRepo.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("FIND PRODUCT ERROR: Product with the ID " + id + " was not found."));
    }

    public Product updateProduct(Product product){
        Product updatedProduct = productRepo.findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException("UPDATE ERROR: Product with the ID " + product.getId() + " was not found."));
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setSalePrice(product.getSalePrice());
        updatedProduct.setSale(product.getSale());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setReviews(product.getReviews());
        updatedProduct.setAvailability(product.getAvailability());
        updatedProduct.setImageSource(product.getImageSource());
        return this.productRepo.save(updatedProduct);
    }

    public void deleteProduct(Long id){
        this.productRepo.deleteById(id);
    }
}
