package com.example.demo.service;

import com.example.demo.model.ConflictCase;
import java.util.List;
import java.util.Optional;

public interface ConflictCaseService {
    ConflictCase createCase(ConflictCase conflictCase);
    ConflictCase updateCaseStatus(Long id, String status);
    List<ConflictCase> getAllCases();
    List<ConflictCase> getCasesByPerson(Long personId);
    Optional<ConflictCase> getCaseById(Long id);
}
