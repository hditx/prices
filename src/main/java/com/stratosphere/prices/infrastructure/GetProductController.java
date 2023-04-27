package com.stratosphere.prices.infrastructure;

import com.stratosphere.prices.application.FindPrices;
import com.stratosphere.prices.application.ProductCriteria;
import com.stratosphere.prices.domain.BrandRepository;
import com.stratosphere.prices.domain.PricesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/product")
public class GetProductController {

    private PricesRepository pricesRepository;
    private BrandRepository brandRepository;
    private FindPrices findPrices;

    public GetProductController(PricesRepository pricesRepository, BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
        this.pricesRepository = pricesRepository;
        this.findPrices = new FindPrices(this.pricesRepository, this.brandRepository);
    }
    @GetMapping
    public ResponseEntity<?> invoke(ProductCriteria criteria) throws ParseException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findPrices.invoke(criteria));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(ProductCriteria criteria) throws ParseException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Hola");
    }
}
