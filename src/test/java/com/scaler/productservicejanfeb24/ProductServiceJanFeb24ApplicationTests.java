package com.scaler.productservicejanfeb24;

import com.scaler.productservicejanfeb24.models.Category;
import com.scaler.productservicejanfeb24.models.Product;
import com.scaler.productservicejanfeb24.repositories.CategoryRepository;
import com.scaler.productservicejanfeb24.repositories.ProductRepository;
import com.scaler.productservicejanfeb24.repositories.projections.ProductTitleAndDesc;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceJanFeb24ApplicationTests
{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void findByTitleAndCategory_titleTest()
    {
        Optional<Product> productOptional = productRepository
                .findByTitleAndCategory_title("iPhone 16", "electronic");

        System.out.println(productOptional.get().getTitle());
    }

    @Test
    void getProductTitleTest()
    {
        List<Product> productList = productRepository
                .getProductData("electronic");

        System.out.println(productList.get(0).getTitle());

    }

    @Test
    void getProductDataNativeTest()
    {
        Product product = productRepository
                .getProductDataNative(1L);

        System.out.println(product.getTitle());
    }

    @Test
    void getProductDataFromProjectionTest()
    {
        ProductTitleAndDesc productTitleAndDesc = productRepository
                .getProductDataFromProjection(2L);

        System.out.println(productTitleAndDesc.getTitle() + ", " + productTitleAndDesc.getDescription());
    }

    @Test
    @Transactional
    void JPAFetchTypeTest()
    {
        Optional<Category> category = categoryRepository
                .findById(1L);

        System.out.println(category.get().getTitle());
        System.out.println(category.get().getProducts());
    }

    @Test
    void JPANPlusOneProblemTest()
    {
        List<Category> categories = categoryRepository.findAll();

        for(Category category : categories)
        {
            for(Product product : category.getProducts())
            {
                System.out.println(product.getTitle());
            }
        }
    }

}
