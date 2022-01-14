package com.jpa.converter;

import com.jpa.enumable.ProductType;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class ProductTypeConverter implements AttributeConverter<ProductType, String> {
    @Override
    public String convertToDatabaseColumn(ProductType attribute) {
        return attribute.getCode();
    }

    @Override
    public ProductType convertToEntityAttribute(String dbData) {
        return Arrays.stream(ProductType.values())
                .filter(el -> el.getCode().equals(dbData))
                .findAny().orElse(null);
    }
}
