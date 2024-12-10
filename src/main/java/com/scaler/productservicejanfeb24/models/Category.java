package com.scaler.productservicejanfeb24.models;

public class Category {
    private long id;
    private String title;

    public Category(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Category() {
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(long id) {
        this.id = id;
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
