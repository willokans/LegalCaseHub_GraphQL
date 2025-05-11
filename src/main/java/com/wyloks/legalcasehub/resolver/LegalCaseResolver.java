package com.wyloks.legalcasehub.resolver;

import com.wyloks.legalcasehub.model.LegalCase;
import com.wyloks.legalcasehub.repository.LegalCaseRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.time.LocalDate;
import java.util.List;

public class LegalCaseResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final LegalCaseRepository repository;

    public LegalCaseResolver(LegalCaseRepository repository) {
        this.repository = repository;
    }

    public List<LegalCase> getLegalCases() {
        return repository.findAll();
    }

    public LegalCase getLegalCaseById(String id) {
        return repository.findById(id).orElse(null);
    }

    public LegalCase addCase(String title, String court, String date, String summary,
                             List<String> keywords, String fullText, Boolean isPublic) {
        LegalCase legalCase = new LegalCase();
        legalCase.setTitle(title);
        legalCase.setCourt(court);
        legalCase.setDate(LocalDate.parse(date));
        legalCase.setSummary(summary);
        legalCase.setKeywords(keywords);
        legalCase.setFullText(fullText);
        legalCase.setPublic(isPublic);
        return repository.save(legalCase);
    }

    public LegalCase createLegalCase(LegalCase legalCase) {
        return repository.save(legalCase);
    }

    public LegalCase updateLegalCase(String id, LegalCase legalCase) {
        if (repository.existsById(id)) {
            legalCase.setId(id);
            return repository.save(legalCase);
        }
        return null;
    }
}
