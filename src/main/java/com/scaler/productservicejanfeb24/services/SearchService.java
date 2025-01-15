package com.scaler.productservicejanfeb24.services;

import com.scaler.productservicejanfeb24.models.Product;
import com.scaler.productservicejanfeb24.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SearchService
{
    public ProductRepository productRepository;

    public SearchService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public Page<Product> search(String query, int pageNumber, int size)
    {
//        Sort sort = Sort.by("title").and(Sort.by("description"));
        Sort sort = Sort.by("title").ascending();
        // Data, Metadata
        Pageable pageable = PageRequest.of(pageNumber, size, sort);

        return productRepository.findByTitleContaining(query, pageable);
    }
}
