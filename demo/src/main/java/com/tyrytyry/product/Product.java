package com.tyrytyry.product;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private String imageUrl;

    public Product(String id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl= imageUrl;
    }
}
