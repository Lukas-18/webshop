package alz.genfive.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    //private Map<Product, Integer> items;

}
