package com.wyloks.legalcasehub.integrationTest;

import com.wyloks.legalcasehub.model.LegalCase;
import com.wyloks.legalcasehub.repository.LegalCaseRepository;
import com.wyloks.legalcasehub.resolver.LegalCaseResolver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test") // Use a test profile with an in-memory database
public class LegalCaseResolverIntegrationTest {

    @Autowired
    private LegalCaseRepository repository;

    @Autowired
    private LegalCaseResolver resolver;

    @AfterEach
    void clearUp() {
        repository.deleteAll();
    }

    @Test
    void testGetLegalCases() {
        repository.save(new LegalCase(null, "Case 1", "Court 1", LocalDate.now(), "Summary 1", List.of("keyword1"), "Full text 1", true));
        repository.save(new LegalCase(null, "Case 2", "Court 2", LocalDate.now(), "Summary 2", List.of("keyword2"), "Full text 2", false));

        List<LegalCase> cases = resolver.getLegalCases();

        assertEquals(2, cases.size());
    }

    @Test
    void testAddCase() {
        LegalCase legalCase = resolver.addCase("Case 1", "Court 1", LocalDate.now().toString(), "Summary 1", List.of("keyword1"), "Full text 1", true);

        assertNotNull(legalCase.getId());
        assertEquals("Case 1", legalCase.getTitle());
    }

    @Test
    void testCreateCase() {
        LegalCase legalCase = new LegalCase(null, "Case 1", "Court 1", LocalDate.now(), "Summary 1", List.of("keyword1"), "Full text 1", true);
        resolver.createLegalCase(legalCase);

        assertNotNull(legalCase.getId());
        assertEquals("Case 1", legalCase.getTitle());
        repository.deleteAll();
    }

    @Test
    void testUpdateLegalCase() {
        LegalCase savedCase = repository.save(new LegalCase(null, "Case 1", "Court 1", LocalDate.now(), "Summary 1", List.of("keyword1"), "Full text 1", true));
        savedCase.setTitle("Updated Case");

        LegalCase updatedCase = resolver.updateLegalCase(savedCase.getId(), savedCase);

        assertEquals("Updated Case", updatedCase.getTitle());
    }
}
