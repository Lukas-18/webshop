package alz.genfive.webshop.model;

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
public class User implements Serializable {
    @Id // Tells that this is gone be the primary key in the DB.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // How to generate this information. Inside the brackets Pass in the strategy
    @Column(nullable = false, updatable = false) // Specify information for this column. Inside the brackets it says that this column cannot be null and cannot be updated.
    private Long id;
    private String email;
    private String firstname;
    private String surname;
    private String password;
    private Address address;
    private ShoppingCart shoppingCart;
    private List<PaymentMethod> payments;

}
