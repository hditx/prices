package com.stratosphere.prices.application;

import com.stratosphere.prices.domain.Brand;
import com.stratosphere.prices.domain.BrandRepository;
import com.stratosphere.prices.domain.Product;
import com.stratosphere.prices.domain.PricesRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindPrices {
    private final PricesRepository pricesRepository;
    private final BrandRepository brandRepository;

    public FindPrices(PricesRepository pricesRepository, BrandRepository brandRepository) {
        this.pricesRepository = pricesRepository;
        this.brandRepository = brandRepository;
    }
    public List<Product> invoke(ProductCriteria productCriteria) throws ParseException {
        Date date = parseDate(productCriteria.getDate());
        return pricesRepository
                .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                    productCriteria.getProduct(),
                    getBrand(productCriteria.getBrand()),
                    date,
                    date
                )
                .stream()
                .filter(item -> item.getPriority() == 1L)
                .toList();
    }

    private Date parseDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        return format.parse(date);
    }

    private Brand getBrand(Long brandId) {
        return brandRepository.findById(brandId).get();
    }
}
