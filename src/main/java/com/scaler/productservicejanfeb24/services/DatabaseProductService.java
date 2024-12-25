package com.scaler.productservicejanfeb24.services;

import com.scaler.productservicejanfeb24.exceptions.ProductNotFoundException;
import com.scaler.productservicejanfeb24.models.Category;
import com.scaler.productservicejanfeb24.models.Product;
import com.scaler.productservicejanfeb24.repositories.CategoryRepository;
import com.scaler.productservicejanfeb24.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("databaseProductService")
public class DatabaseProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DatabaseProductService(ProductRepository productRepository,
                                  CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException
    {
        Optional<Product> productOptionalFromDb =   productRepository.findById(id);

        if(productOptionalFromDb.isEmpty())
        {
            throw new ProductNotFoundException("Product not found");
        }

        return productOptionalFromDb.get();
    }

    @Override
    public Product CreateProduct(String title, String description, double price, String category, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category categoryfromDatabase = categoryRepository.findByTitle(category);
        if(categoryfromDatabase == null)
        {
            Category newCategory = new Category();
            newCategory.setTitle(category);

            categoryfromDatabase = newCategory;

//            categoryfromDatabase = categoryRepository.save(newCategory);
        }

        product.setCategory(categoryfromDatabase);

        return productRepository.save(product);
    }
}
