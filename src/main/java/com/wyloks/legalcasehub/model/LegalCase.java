package com.wyloks.legalcasehub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "legal_cases")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LegalCase {
    @Id
    private String id;
    private String title;
    private String court;
    private LocalDate date;
    private String summary;
    private List<String> keywords;
    private String fullText;
    private boolean isPublic;
}
