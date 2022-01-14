package com.jpa.repository;

import com.jpa.entity.StringProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringProductRepository extends JpaRepository<StringProduct, Long> {
}
