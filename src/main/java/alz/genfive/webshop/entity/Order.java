package alz.genfive.webshop.entity;

import alz.genfive.webshop.enumeration.ShippingState;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    //@OneToMany
    //private Map<Product, Integer> items;
    @OneToOne
    @JoinColumn(name = "payment", referencedColumnName = "id")
    private PaymentMethod payment;
    private Boolean paid;
    private ShippingState shippingState;
    private Date date;

}
