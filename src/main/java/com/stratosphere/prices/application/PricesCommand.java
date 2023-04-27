package com.stratosphere.prices.application;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public final class PricesCommand implements Serializable {
    private Long productId;
    private Long brandId;
    private Long priceList;
    private Double price;
    private String startDate;
    private String endDate;
}
