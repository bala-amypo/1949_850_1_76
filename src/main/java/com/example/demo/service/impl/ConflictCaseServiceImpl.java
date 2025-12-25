package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repository;
    private final ConflictFlagRepository flagRepository;

    public ConflictCaseServiceImpl(
            ConflictCaseRepository repository,
            ConflictFlagRepository flagRepository) {
        this.repository = repository;
        this.flagRepository = flagRepository;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        return repository.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long caseId, String status) {
        ConflictCase conflictCase = getCaseById(caseId);
        conflictCase.setStatus(status);
        return repository.save(conflictCase);
    }

    @Override
    public ConflictCase getCaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiException("case not found"));
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repository.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repository.findAll();
    }
}
