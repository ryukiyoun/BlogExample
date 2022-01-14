package com.jpa.entity;

import com.jpa.enumable.ProductType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrdinalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private int price;

    private double weight;

    @Enumerated(EnumType.ORDINAL)
    private ProductType productType;
}
