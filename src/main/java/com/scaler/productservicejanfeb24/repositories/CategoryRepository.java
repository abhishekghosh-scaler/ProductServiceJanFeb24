package com.scaler.productservicejanfeb24.repositories;

import com.scaler.productservicejanfeb24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Category findByTitle(String title);

    Category save(Category category);

}
