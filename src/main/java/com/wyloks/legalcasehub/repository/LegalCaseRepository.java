package com.wyloks.legalcasehub.repository;

import com.wyloks.legalcasehub.model.LegalCase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LegalCaseRepository extends MongoRepository<LegalCase, String> {
}
