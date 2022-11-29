package com.your.choice.brigadeservice.repository;

import com.your.choice.brigadeservice.entity.ShiftEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ShiftRepository extends ElasticsearchRepository<ShiftEntity, String> {

    List<ShiftEntity> findAll();
}
