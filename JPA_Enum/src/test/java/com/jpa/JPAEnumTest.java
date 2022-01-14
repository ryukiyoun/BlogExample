package com.jpa;

import com.jpa.entity.ConvertProduct;
import com.jpa.entity.OrdinalProduct;
import com.jpa.entity.StringProduct;
import com.jpa.enumable.ProductType;
import com.jpa.repository.ConvertProductRepository;
import com.jpa.repository.OrdinalProductRepository;
import com.jpa.repository.StringProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JPAEnumTest {
    @Autowired
    OrdinalProductRepository ordinalProductRepository;

    @Autowired
    StringProductRepository stringProductRepository;

    @Autowired
    ConvertProductRepository convertProductRepository;

    @Test
    public void EnumTypeORDINALTest(){
        OrdinalProduct book = OrdinalProduct.builder()
                .name("book1")
                .price(10000)
                .weight(1.6)
                .productType(ProductType.BOOK)
                .build();

        OrdinalProduct cd = OrdinalProduct.builder()
                .name("cd")
                .price(20000)
                .weight(0.6)
                .productType(ProductType.CD)
                .build();

        ordinalProductRepository.save(book);

        ordinalProductRepository.save(cd);

        OrdinalProduct ordinalProduct = ordinalProductRepository.findById(book.getId()).orElse(null);

        assertThat(ordinalProduct, is(not(nullValue())));
        assertThat(ordinalProduct.getProductType(), is(instanceOf(ProductType.class)));
        assertThat(ordinalProduct.getProductType().getValue(), is(ProductType.BOOK.getValue()));
    }

    @Test
    public void EnumTypeSTRINGTest(){
        StringProduct book = StringProduct.builder()
                .name("book1")
                .price(10000)
                .weight(1.6)
                .productType(ProductType.BOOK)
                .build();

        StringProduct cd = StringProduct.builder()
                .name("cd")
                .price(20000)
                .weight(0.6)
                .productType(ProductType.CD)
                .build();

        stringProductRepository.save(book);

        stringProductRepository.save(cd);

        StringProduct stringProduct = stringProductRepository.findById(book.getId()).orElse(null);

        assertThat(stringProduct, is(not(nullValue())));
        assertThat(stringProduct.getProductType().getValue(), is(ProductType.BOOK.getValue()));
    }

    @Test
    public void EnumTypeAttributeConverterTest(){
        ConvertProduct book = ConvertProduct.builder()
                .name("book1")
                .price(10000)
                .weight(1.6)
                .productType(ProductType.BOOK)
                .build();

        ConvertProduct cd = ConvertProduct.builder()
                .name("cd")
                .price(20000)
                .weight(0.6)
                .productType(ProductType.CD)
                .build();

        convertProductRepository.save(book);

        convertProductRepository.save(cd);

        ConvertProduct convertProduct = convertProductRepository.findById(book.getId()).orElse(null);

        assertThat(convertProduct, is(not(nullValue())));
        assertThat(convertProduct.getProductType().getValue(), is(ProductType.BOOK.getValue()));
    }
}
