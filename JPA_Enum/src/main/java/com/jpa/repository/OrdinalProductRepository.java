package com.jpa.repository;

import com.jpa.entity.OrdinalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinalProductRepository extends JpaRepository<OrdinalProduct, Long> {

}
