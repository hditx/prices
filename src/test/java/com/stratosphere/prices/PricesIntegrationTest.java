package com.stratosphere.prices;

import com.stratosphere.prices.application.PricesCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PricesIntegrationTest {
    private final String URL = "http://localhost:8080/api/v1/product?date={date}&brand={brand}&product={product}";
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void endpointGetTestOne() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("product", "35455");
        uriVariables.put("brand", "1");
        uriVariables.put("date", "2020-06-14 10:00:00");
        ResponseEntity<List> response = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, List.class, uriVariables);
        Assertions.assertEquals(true, response.getBody().isEmpty());
    }

    @Test
    public void endpointGetTestTwo() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("product", "35455");
        uriVariables.put("brand", "1");
        uriVariables.put("date", "2020-06-14 16:00:00");
        ResponseEntity<List> response = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, List.class, uriVariables);
        var body = (LinkedHashMap) response.getBody().get(0);
        var priceCommand = PricesCommand.builder()
                .brandId(Long.valueOf(body.get("brandId").toString()))
                .price(Double.valueOf(body.get("price").toString()))
                .priceList(Long.valueOf(body.get("priceList").toString()))
                .productId(Long.valueOf(body.get("productId").toString()))
                .startDate(body.get("startDate").toString())
                .endDate(body.get("endDate").toString())
                .build();
        Assertions.assertEquals(25.45, priceCommand.getPrice());
    }

    @Test
    public void endpointGetTestThree() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("product", "35455");
        uriVariables.put("brand", "1");
        uriVariables.put("date", "2020-06-14 21:00:00");
        ResponseEntity<List> response = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, List.class, uriVariables);
        Assertions.assertEquals(true, response.getBody().isEmpty());
    }

    @Test
    public void endpointGetTestFour() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("product", "35455");
        uriVariables.put("brand", "1");
        uriVariables.put("date", "2020-06-15 10:00:00");
        ResponseEntity<List> response = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, List.class, uriVariables);
        var body = (LinkedHashMap) response.getBody().get(0);
        var priceCommand = PricesCommand.builder()
                .brandId(Long.valueOf(body.get("brandId").toString()))
                .price(Double.valueOf(body.get("price").toString()))
                .priceList(Long.valueOf(body.get("priceList").toString()))
                .productId(Long.valueOf(body.get("productId").toString()))
                .startDate(body.get("startDate").toString())
                .endDate(body.get("endDate").toString())
                .build();
        Assertions.assertEquals(30.5, priceCommand.getPrice());
    }

    @Test
    public void endpointGetTestFive() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("product", "35455");
        uriVariables.put("brand", "1");
        uriVariables.put("date", "2020-06-16 21:00:00");
        ResponseEntity<List> response = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, List.class, uriVariables);
        var body = (LinkedHashMap) response.getBody().get(0);
        var priceCommand = PricesCommand.builder()
                .brandId(Long.valueOf(body.get("brandId").toString()))
                .price(Double.valueOf(body.get("price").toString()))
                .priceList(Long.valueOf(body.get("priceList").toString()))
                .productId(Long.valueOf(body.get("productId").toString()))
                .startDate(body.get("startDate").toString())
                .endDate(body.get("endDate").toString())
                .build();
        Assertions.assertEquals(38.95, priceCommand.getPrice());
    }

}
