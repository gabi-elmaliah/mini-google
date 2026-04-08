package com.gabbyelmaliah.minigoogle.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "documents")
public class DocumentEntity {
    @Id
    private String id;
    private String title;
    private String content;
}
