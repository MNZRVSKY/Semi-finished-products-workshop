package com.your.choice.finishedproductservise.repository;

import com.your.choice.finishedproductservise.entity.FinishedProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinishedProductRepository extends JpaRepository<FinishedProducts, Long> {
}
