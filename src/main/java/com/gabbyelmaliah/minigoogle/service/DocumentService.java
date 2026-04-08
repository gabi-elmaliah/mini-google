package com.gabbyelmaliah.minigoogle.service;

import com.gabbyelmaliah.minigoogle.kafka.DocumentProducer;
import com.gabbyelmaliah.minigoogle.model.DocumentEntity;
import com.gabbyelmaliah.minigoogle.repo.DocumentRepository;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private final DocumentRepository repository;
    private final ElasticsearchOperations elasticsearchOperations;
    private final DocumentProducer producer;


    public DocumentService(DocumentRepository repository,ElasticsearchOperations elasticsearchOperations, DocumentProducer producer) {
        this.repository = repository;
        this.elasticsearchOperations = elasticsearchOperations;
        this.producer = producer;
    }

    public void save(DocumentEntity document) {
        producer.send(document);
    }

    public List<DocumentEntity> search(String query) {

        NativeQuery searchQuery = new NativeQueryBuilder()
                .withQuery(q -> q
                        .multiMatch(m -> m
                                .query(query)
                                .fields("title^2", "content")
                                .fuzziness("AUTO")
                        )
                )
                .build();


        SearchHits<DocumentEntity> hits =
                elasticsearchOperations.search(searchQuery, DocumentEntity.class);

        return hits.stream()
                .map(hit -> hit.getContent())
                .collect(Collectors.toList());
    }

}