package alz.genfive.webshop.model;

import alz.genfive.webshop.enumeration.ShippingState;

import java.util.Date;
import java.util.Map;

public class Order {
    private Long id;
    private User user;
    private Map<Product, Integer> items;
    private PaymentMethod payment;
    private Boolean paid;
    private ShippingState shippingState;
    private Date date;

}
