package com.your.choice.brigadeservice.repository;

import com.your.choice.brigadeservice.entity.WorkerEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface WorkerRepository extends ElasticsearchRepository<WorkerEntity, String> {

    List<WorkerEntity> findAll();
}
