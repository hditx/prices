package com.stratosphere.prices.mothers;

import com.stratosphere.prices.domain.Brand;

public class BrandMother {
    public static Brand generateBrand() {
        Brand brand = new Brand();
        brand.setBrandId(1L);
        brand.setName("ZARA");
        return brand;
    }
}
