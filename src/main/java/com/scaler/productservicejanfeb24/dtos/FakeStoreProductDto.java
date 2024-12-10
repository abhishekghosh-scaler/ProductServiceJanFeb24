package com.scaler.productservicejanfeb24.dtos;

import com.scaler.productservicejanfeb24.models.Category;
import com.scaler.productservicejanfeb24.models.Product;

public class FakeStoreProductDto {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);

        Category category1 = new Category();
        category1.setTitle(category);
        product.setCategory(category1);

        product.setImageUrl(image);
        return product;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public String getImage() {
        return this.image;
    }

    public String getCategory() {
        return this.category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
