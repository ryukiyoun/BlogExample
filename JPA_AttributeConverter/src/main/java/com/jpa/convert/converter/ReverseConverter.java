package com.jpa.convert.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ReverseConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        StringBuilder stringBuilder = new StringBuilder(attribute);
        return stringBuilder.reverse().toString();
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData + "_converter";
    }
}
