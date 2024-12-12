package com.scaler.productservicejanfeb24.services;

import com.scaler.productservicejanfeb24.dtos.CreateProductDto;
import com.scaler.productservicejanfeb24.models.Product;

import java.util.List;

public interface ProductService
{
    List<Product> getAllProducts();
    Product getSingleProduct(long id);

    Product CreateProduct(CreateProductDto createProductDto);
}
