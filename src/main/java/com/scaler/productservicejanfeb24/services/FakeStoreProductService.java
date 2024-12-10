package com.scaler.productservicejanfeb24.services;

import com.scaler.productservicejanfeb24.dtos.CreateProductDto;
import com.scaler.productservicejanfeb24.dtos.FakeStoreProductDto;
import com.scaler.productservicejanfeb24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService
{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    /*
    * This method is used to call the third-party API to fetch the data
    * https://fakestoreapi.com/products/
    * */
    @Override
    public Product getSingleProduct(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public void CreateProduct(CreateProductDto createProductDto) {

    }
}
