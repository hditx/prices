package com.stratosphere.prices.application;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
public final class ProductCriteria implements Serializable {
    private String date;
    private Long brand;
    private Long product;
}
