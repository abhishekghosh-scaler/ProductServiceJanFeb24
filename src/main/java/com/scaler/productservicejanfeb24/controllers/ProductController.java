package com.scaler.productservicejanfeb24.controllers;

import com.scaler.productservicejanfeb24.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    /*
    * API: methods in controller
    * */

    /*
    * GET /products: Get all products
    * */
    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return null;
    }

    /*
    * GET /products/{id}
    * */
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id)
    {
        return null;
    }

    /*
    * POST /products: Create a new product
    * */
    @PostMapping("/products")
    public void createProduct()
    {

    }
}
