package com.scaler.productservicejanfeb24.controllers;

import com.scaler.productservicejanfeb24.dtos.CreateProductDto;
import com.scaler.productservicejanfeb24.dtos.ErrorDto;
import com.scaler.productservicejanfeb24.exceptions.ProductNotFoundException;
import com.scaler.productservicejanfeb24.models.Product;
import com.scaler.productservicejanfeb24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{

    private ProductService productService;

    public ProductController(@Qualifier("databaseProductService") ProductService productService)
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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        Product product = productService.getSingleProduct(id);

        ResponseEntity<Product> responseProductEntity;

        if(product == null)
        {
            responseProductEntity = new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
        else
        {
            responseProductEntity = new ResponseEntity<>(product, HttpStatus.OK);
        }

        return responseProductEntity;
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
    /*
    * We're changing the return type from void to Product just for testing
    * */
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductDto createProductDto)
    {
        return productService.CreateProduct(createProductDto.getTitle(),
                createProductDto.getDescription(),
                createProductDto.getPrice(),
                createProductDto.getCategory(),
                createProductDto.getImage());
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException)
//    {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(productNotFoundException.getMessage());
//
//        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}
