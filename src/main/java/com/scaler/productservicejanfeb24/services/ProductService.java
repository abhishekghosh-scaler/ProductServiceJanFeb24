package com.scaler.productservicejanfeb24.services;

import com.scaler.productservicejanfeb24.exceptions.ProductNotFoundException;
import com.scaler.productservicejanfeb24.models.Product;

import java.util.List;

public interface ProductService
{
    List<Product> getAllProducts();
    Product getSingleProduct(long id) throws ProductNotFoundException;

    Product CreateProduct(String title, String description, double price, String category, String image);
}
