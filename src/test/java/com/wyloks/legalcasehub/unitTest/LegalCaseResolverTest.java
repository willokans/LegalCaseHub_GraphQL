package com.wyloks.legalcasehub.unitTest;

import com.wyloks.legalcasehub.model.LegalCase;
import com.wyloks.legalcasehub.repository.LegalCaseRepository;
import com.wyloks.legalcasehub.resolver.LegalCaseResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LegalCaseResolverTest {

    private LegalCaseResolver resolver;
    private LegalCaseRepository repository;

    @BeforeEach
    void setup() {
        repository = mock(LegalCaseRepository.class);
        resolver = new LegalCaseResolver(repository);
    }

    @Test
    void testGetLegalCases() {
        List<LegalCase> cases = Arrays.asList(
                new LegalCase("1", "Case 1", "Court A", LocalDate.now(), "Summary 1", List.of("keyword1"), "Full text 1", true),
                new LegalCase("2", "Case 2", "Court B", LocalDate.now(), "Summary 2", List.of("keyword2"), "Full text 2", false)
        );
        when(repository.findAll()).thenReturn(cases);

        List<LegalCase> result = resolver.getLegalCases();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetLegalCaseById() {
        LegalCase legalCase = new LegalCase("1", "Case 1", "Court A", LocalDate.now(), "Summary 1", List.of("keyword1"), "Full text 1", true);

        when(repository.findById("1")).thenReturn(Optional.of(legalCase));
        LegalCase result = resolver.getLegalCaseById("1");

        assertNotNull(result);
        assertEquals("Case 1", result.getTitle());
        verify(repository, times(1)).findById("1");
    }

    @Test
    void testAddCase() {
        LegalCase legalCase = new LegalCase(null, "Case 1", "Court 1", LocalDate.now(), "Summary 1", List.of("keyword1"), "Full text 1", true);
        when(repository.save(any(LegalCase.class))).thenReturn(legalCase);

        LegalCase result = resolver.addCase("Case 1", "Court 1", LocalDate.now().toString(), "Summary 1", List.of("keyword1"), "Full text 1", true);

        assertNotNull(result);
        assertEquals("Case 1", result.getTitle());
        verify(repository, times(1)).save(any(LegalCase.class));
    }

    @Test
    void testUpdateLegalCase() {
        LegalCase legalCase = new LegalCase("1", "Updated Case", "Court 1", LocalDate.now(), "Updated Summary", List.of("keyword1"), "Updated Full text", true);
        when(repository.existsById("1")).thenReturn(true);
        when(repository.save(any(LegalCase.class))).thenReturn(legalCase);

        LegalCase result = resolver.updateLegalCase("1", legalCase);

        assertNotNull(result);
        assertEquals("Updated Case", result.getTitle());
        verify(repository, times(1)).existsById("1");
        verify(repository, times(1)).save(legalCase);
    }
}
