package com.scaler.productservicejanfeb24.repositories;

import com.scaler.productservicejanfeb24.models.Product;
import com.scaler.productservicejanfeb24.repositories.projections.ProductTitleAndDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product save(Product product);

    Optional<Product> findById(long id);

    List<Product> findAll();

    Optional<Product> findByTitleAndCategory_title(String title, String categoryTitle);

    @Query("select p from Product p where p.category.title = :categoryTitle")
    List<Product> getProductData(@Param("categoryTitle") String categoryTitle);

    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product getProductDataNative(@Param("id") Long id);

    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductTitleAndDesc getProductDataFromProjection(@Param("id") Long id);
}
