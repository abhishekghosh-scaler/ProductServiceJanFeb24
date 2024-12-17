package com.scaler.productservicejanfeb24.services;

import com.scaler.productservicejanfeb24.dtos.CreateProductDto;
import com.scaler.productservicejanfeb24.dtos.FakeStoreProductDto;
import com.scaler.productservicejanfeb24.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
        /* Getting an array of FakeStoreDTO objects */
        FakeStoreProductDto[] fakeStoreProductDtoArray = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        //Creating a list, which will be returned by the method
        List<Product> products = new ArrayList<>();

        //Iterate over the array and convert individual FakeStore DTO to product, then add the product to list
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoArray)
        {
            Product product = fakeStoreProductDto.toProduct();
            products.add(product);
        }

        return products;
    }

    /*
    * This method is used to call the third-party API to fetch the data
    * https://fakestoreapi.com/products/
    * */
    @Override
    public Product getSingleProduct(long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductEntity.getBody();

        if(fakeStoreProductDto == null)
        {
            return null;
        }

        return fakeStoreProductDto.toProduct();
    }

    /*
     * This is dummy a dummy endpoint. It does nothing.
     * */
    @Override
    public Product CreateProduct(String title, String description, double price, String category, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto fakeStoreProductDto1 =  restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);

        return fakeStoreProductDto1.toProduct();
    }

}
