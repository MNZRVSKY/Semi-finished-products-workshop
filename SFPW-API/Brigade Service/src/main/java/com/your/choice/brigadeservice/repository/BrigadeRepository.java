package com.your.choice.brigadeservice.repository;

import com.your.choice.brigadeservice.entity.BrigadeEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BrigadeRepository extends ElasticsearchRepository<BrigadeEntity, String> {

    List<BrigadeEntity> findAll();
}
