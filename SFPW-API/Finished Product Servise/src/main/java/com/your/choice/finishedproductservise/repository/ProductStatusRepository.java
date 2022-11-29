package com.your.choice.finishedproductservise.repository;

import com.your.choice.finishedproductservise.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStatusRepository extends JpaRepository<ProductStatus, Long> {
}
