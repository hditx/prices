package com.stratosphere.prices.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    @Id
    private Long id;
    private Long productId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "brand_id")
    private Brand brandId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    private Long priceList;
    private Double price;
    private Integer priority;
    private String curr;
}
