package com.scaler.productservicejanfeb24;

import com.scaler.productservicejanfeb24.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceJanFeb24Application {

    public static void main(String[] args)
    {
        Product p1 = new Product();

        SpringApplication.run(ProductServiceJanFeb24Application.class, args);
    }

}
