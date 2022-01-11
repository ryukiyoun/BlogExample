package com.jpa;

import com.jpa.convert.entity.NameEntity;
import com.jpa.convert.repository.NameRepository;
import com.jpa.convert.service.NameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AttributeConverterTest {
    @Autowired
    NameService nameService;
    
    @Autowired
    NameRepository nameRepository;

    @Test
    public void ConverterTest(){
        NameEntity entity = NameEntity.builder()
                .name("hello")
                .convertName("hello")
                .build();

        entity = nameService.saveNameEntity(entity);
        
        NameEntity getNameEntity = nameRepository.findById(entity.getId()).orElse(null);

        assertThat(getNameEntity, is(not(nullValue())));
        assertThat(getNameEntity.getConvertName(), is("olleh_converter"));
    }
}
