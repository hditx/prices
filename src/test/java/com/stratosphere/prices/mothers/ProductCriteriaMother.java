package com.stratosphere.prices.mothers;

import com.stratosphere.prices.application.ProductCriteria;

public class ProductCriteriaMother {
    public static ProductCriteria generateProductCriteriaReturnEmpty() {
        ProductCriteria productCriteria = new ProductCriteria();
        productCriteria.setProduct(1L);
        productCriteria.setBrand(2L);
        productCriteria.setDate("2020-06-10 21:00:00");
        return productCriteria;
    }

    public static ProductCriteria generateProductCriteriaFormatNotValid() {
        ProductCriteria productCriteria = new ProductCriteria();
        productCriteria.setProduct(1L);
        productCriteria.setBrand(2L);
        productCriteria.setDate("q-06-10 21:00:00");
        return productCriteria;
    }

    public static ProductCriteria generateProductCriteria() {
        ProductCriteria productCriteria = new ProductCriteria();
        productCriteria.setProduct(35455L);
        productCriteria.setBrand(1L);
        productCriteria.setDate("2020-06-16 21:00:00");
        return productCriteria;
    }
}
