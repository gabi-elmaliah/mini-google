package com.gabbyelmaliah.minigoogle.kafka;


import com.gabbyelmaliah.minigoogle.model.DocumentEntity;
import com.gabbyelmaliah.minigoogle.repo.DocumentRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DocumentConsumer {

    private final DocumentRepository repository;

    public DocumentConsumer(DocumentRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "documents.raw", groupId = "minigoogle-group")
    public void consume(DocumentEntity document) {

        System.out.println("Received document: " + document);

        // Save into Elasticsearch
        repository.save(document);
    }
}