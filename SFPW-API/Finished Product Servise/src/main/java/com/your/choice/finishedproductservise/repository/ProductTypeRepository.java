package com.your.choice.finishedproductservise.repository;

import com.your.choice.finishedproductservise.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
