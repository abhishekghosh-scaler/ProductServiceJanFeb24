package com.scaler.productservicejanfeb24.controllers;

import com.scaler.productservicejanfeb24.dtos.SearchRequestDto;
import com.scaler.productservicejanfeb24.models.Product;
import com.scaler.productservicejanfeb24.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController
{
    public SearchService searchService;

    public SearchController(SearchService searchService)
    {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestDto searchRequestDto)
    {
        return searchService.search(searchRequestDto.getQuery(),
                searchRequestDto.getPageNumber(),
                searchRequestDto.getSize());
    }
}
