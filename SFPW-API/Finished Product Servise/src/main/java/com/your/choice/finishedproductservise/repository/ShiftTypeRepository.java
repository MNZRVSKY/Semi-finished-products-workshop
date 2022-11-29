package com.your.choice.finishedproductservise.repository;

import com.your.choice.finishedproductservise.entity.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftTypeRepository extends JpaRepository<ShiftType, Long> {
    ShiftType findShiftTypeByType(String type);
}
