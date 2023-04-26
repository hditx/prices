package com.stratosphere.prices.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PricesRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long productId, Brand brandId, Date startDate, Date endDate);
}
