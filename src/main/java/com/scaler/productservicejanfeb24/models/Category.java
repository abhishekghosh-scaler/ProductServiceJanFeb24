package com.scaler.productservicejanfeb24.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Category extends BaseModel implements Serializable {
    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE
    , fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Product> products;

    public List<Product> getProducts()
    {
        return products;
    }

    public Category(String title) {
        this.title = title;
    }

    public Category() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

/*
* P C
* 1 1
* m 1 -> Cardinality
* */
