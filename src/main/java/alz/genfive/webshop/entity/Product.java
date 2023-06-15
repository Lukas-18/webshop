package alz.genfive.webshop.entity;

import alz.genfive.webshop.enumeration.Availability;
import alz.genfive.webshop.enumeration.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private Float price;
    private Category category;
    @OneToMany
    private List<Review> reviews;
    private Availability availability;
    private String image;

}
