package com.stratosphere.prices.mothers;

import com.stratosphere.prices.application.PricesCommand;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PricesMother {
    public static PricesCommand generatePricesCommand() {
        return PricesCommand
                .builder()
                .price(38.95)
                .priceList(4L)
                .brandId(1L)
                .productId(35455L)
                .startDate("2020-06-15 16:00:00")
                .endDate("2020-12-31 23:59:59")
                .build();
    }
}
