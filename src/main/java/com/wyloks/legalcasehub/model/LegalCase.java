package com.wyloks.legalcasehub.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document(collection = "legal_cases")
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
