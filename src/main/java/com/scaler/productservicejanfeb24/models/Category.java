package com.scaler.productservicejanfeb24.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category
{
    private long id;
    private String title;
}

/*
* P C
* 1 1
* m 1 -> Cardinality
* */
