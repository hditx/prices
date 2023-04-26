package com.stratosphere.prices.mothers;

import com.stratosphere.prices.domain.Brand;
import com.stratosphere.prices.domain.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductMother {
    public static List<Product> generateProductList() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        List<Product> products = new ArrayList<>();
        Product productOne = new Product();
        Product productTwo = new Product();
        Brand brand = BrandMother.generateBrand();
        productOne.setProductId(35455L);
        productOne.setStartDate(format.parse("2020-06-14 00:00:00"));
        productOne.setPriority(0);
        productOne.setCurr("EUR");
        productOne.setPriceList(4L);
        productOne.setEndDate(format.parse("2020-12-31 23:59:59"));
        productOne.setId(1L);
        productOne.setPrice(38.95);
        productOne.setBrandId(brand);

        productTwo.setProductId(35455L);
        productTwo.setStartDate(format.parse("2020-06-15 16:00:00"));
        productTwo.setPriority(1);
        productTwo.setCurr("EUR");
        productTwo.setPriceList(4L);
        productTwo.setEndDate(format.parse("2020-12-31 23:59:59"));
        productTwo.setId(4L);
        productTwo.setPrice(38.95);
        productTwo.setBrandId(brand);

        products.add(productOne);
        products.add(productTwo);

        return products;
    }

    public static Product generateProduct() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        Product product = new Product();
        Brand brand = BrandMother.generateBrand();
        product.setProductId(35455L);
        product.setStartDate(format.parse("2020-06-15 16:00:00"));
        product.setPriority(1);
        product.setCurr("EUR");
        product.setPriceList(4L);
        product.setEndDate(format.parse("2020-12-31 23:59:59"));
        product.setId(4L);
        product.setPrice(38.95);
        product.setBrandId(brand);
        return product;
    }
}
