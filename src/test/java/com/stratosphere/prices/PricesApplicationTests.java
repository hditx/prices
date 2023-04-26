package com.stratosphere.prices;

import com.stratosphere.prices.application.FindPrices;
import com.stratosphere.prices.domain.Brand;
import com.stratosphere.prices.domain.BrandRepository;
import com.stratosphere.prices.domain.PricesRepository;
import com.stratosphere.prices.application.ProductCriteria;
import com.stratosphere.prices.mothers.BrandMother;
import com.stratosphere.prices.mothers.ProductCriteriaMother;
import com.stratosphere.prices.mothers.ProductMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PricesApplicationTests {
	private PricesRepository pricesRepository;
	private BrandRepository brandRepository;
	private FindPrices findPrices;
	@BeforeEach
	void init() {
		this.brandRepository = mock(BrandRepository.class);
		this.pricesRepository = mock(PricesRepository.class);
		this.findPrices = new FindPrices(pricesRepository, brandRepository);
	}

	@Test
	void findPricesEmpty() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		ProductCriteria productCriteria = ProductCriteriaMother.generateProductCriteriaReturnEmpty();
		when(brandRepository.findById(productCriteria.getBrand())).thenReturn(Optional.of(new Brand()));
		Brand brand = brandRepository.findById(productCriteria.getBrand()).get();
		when(pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
				productCriteria.getProduct(),
				brand,
				format.parse(productCriteria.getDate()),
				format.parse(productCriteria.getDate()))
		)
		.thenReturn(new ArrayList<>());
		var list = findPrices.invoke(productCriteria);
		Assertions.assertEquals(0, list.size());
	}

	@Test
	void findPricesParserException() {
		ProductCriteria productCriteria = ProductCriteriaMother.generateProductCriteriaFormatNotValid();
		when(brandRepository.findById(productCriteria.getBrand())).thenReturn(Optional.of(new Brand()));
		Brand brand = brandRepository.findById(productCriteria.getBrand()).get();
		Assertions.assertThrows(ParseException.class, () -> { findPrices.invoke(productCriteria); });
	}

	@Test
	void findPrices() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		ProductCriteria productCriteria = ProductCriteriaMother.generateProductCriteria();

		when(brandRepository.findById(productCriteria.getBrand())).thenReturn(Optional.of(BrandMother.generateBrand()));
		Brand brand = brandRepository.findById(productCriteria.getBrand()).get();

		when(pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
				productCriteria.getProduct(),
				brand,
				format.parse(productCriteria.getDate()),
				format.parse(productCriteria.getDate()))
		).thenReturn(ProductMother.generateProductList());

		var product = ProductMother.generateProduct();
		var list = findPrices.invoke(productCriteria);
		Assertions.assertEquals(product.getPrice(), list.get(0).getPrice());
	}

}
