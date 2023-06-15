package alz.genfive.webshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity // This maps the class to any database that we have configured on the class path.
@Table(name="webshop_user")
public class User implements Serializable {
    @Id // Tells that this is gone be the primary key in the DB.
    @GeneratedValue(strategy = GenerationType.AUTO) // How to generate this information. Inside the brackets Pass in the strategy
    @Column(nullable = false, updatable = false) // Specify information for this column. Inside the brackets it says that this column cannot be null and cannot be updated.
    private Long id;
    private String email;
    private String firstname;
    private String surname;
    private String password;
    @OneToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;
    @OneToMany
    private List<PaymentMethod> payments;

}
