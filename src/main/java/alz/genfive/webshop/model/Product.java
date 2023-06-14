package alz.genfive.webshop.model;

import alz.genfive.webshop.enumeration.Availability;
import alz.genfive.webshop.enumeration.Category;

import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String description;
    private Float price;
    private Category category;
    private List<Review> reviews;
    private Availability availability;
    private String image;

}
