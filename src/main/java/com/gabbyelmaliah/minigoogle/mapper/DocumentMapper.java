package com.gabbyelmaliah.minigoogle.mapper;

import com.gabbyelmaliah.minigoogle.dto.DocumentRequest;
import com.gabbyelmaliah.minigoogle.dto.DocumentResponse;
import com.gabbyelmaliah.minigoogle.model.DocumentEntity;

import java.util.UUID;

public class DocumentMapper {

    public static DocumentEntity toEntity(DocumentRequest request) {
        return DocumentEntity.builder()
                .id(UUID.randomUUID().toString())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public static DocumentResponse toResponse(DocumentEntity entity) {
        DocumentResponse response = new DocumentResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setContent(entity.getContent());
        return response;
    }
}