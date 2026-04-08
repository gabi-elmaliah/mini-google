package com.gabbyelmaliah.minigoogle.controller;

import com.gabbyelmaliah.minigoogle.dto.DocumentRequest;
import com.gabbyelmaliah.minigoogle.dto.DocumentResponse;
import com.gabbyelmaliah.minigoogle.mapper.DocumentMapper;
import com.gabbyelmaliah.minigoogle.model.DocumentEntity;
import com.gabbyelmaliah.minigoogle.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DocumentRequest request) {

        DocumentEntity entity = DocumentMapper.toEntity(request);
        service.save(entity);
        return ResponseEntity.accepted().build();
    }


    @GetMapping("/search")
    public ResponseEntity<List<DocumentResponse>> search(@RequestParam(required = false) String q) {

        if (q == null || q.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        List<DocumentEntity> results = service.search(q);

        List<DocumentResponse> response = results.stream()
                .map(DocumentMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

}
