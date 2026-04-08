package com.gabbyelmaliah.minigoogle.repo;

import com.gabbyelmaliah.minigoogle.model.DocumentEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends ElasticsearchRepository<DocumentEntity, String> {
}
