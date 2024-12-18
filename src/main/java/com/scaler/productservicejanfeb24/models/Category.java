package com.scaler.productservicejanfeb24.models;


import jakarta.persistence.Entity;

@Entity
public class Category extends BaseModel {
    private String title;

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
