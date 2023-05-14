package com.tyrytyry.product;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private double description;
    private String imageUrl;

    public Product(String id, String name, double description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl= imageUrl;
    }
}
