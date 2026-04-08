package com.gabbyelmaliah.minigoogle.kafka;


import com.gabbyelmaliah.minigoogle.model.DocumentEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DocumentProducer {

    private final KafkaTemplate<String, DocumentEntity> kafkaTemplate;

    public DocumentProducer(KafkaTemplate<String, DocumentEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(DocumentEntity document) {
        kafkaTemplate.send("documents.raw", document);
    }
}