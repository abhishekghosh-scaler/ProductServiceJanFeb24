package com.scaler.productservicejanfeb24.controllers;

import com.scaler.productservicejanfeb24.dtos.CreateProductDto;
import com.scaler.productservicejanfeb24.models.Product;
import com.scaler.productservicejanfeb24.services.FakeStoreProductService;
import com.scaler.productservicejanfeb24.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{

    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    /*
    * API: methods in controller
    * */

    /*
    * GET /products: Get all products
    * */
    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    /*
    * GET /products/{id}
    * */
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id)
    {
        return productService.getSingleProduct(id);
    }

    /*
    * POST /products: Create a new product
    * {
    * title = ______,
    * description = _______,
    * image_url= __________,
    * .
    * .
    * .
    * }
    * */
    @PostMapping("/products")
    public void createProduct(CreateProductDto createProductDto)
    {
        productService.CreateProduct(createProductDto);
    }
}
