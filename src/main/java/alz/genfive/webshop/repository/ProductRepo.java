package alz.genfive.webshop.repository;

import alz.genfive.webshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(Long id);
}
