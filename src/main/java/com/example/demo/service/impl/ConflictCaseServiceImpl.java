package com.example.demo.service.impl;

import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repository;
    private final ConflictFlagRepository flagRepo;



    public ConflictCaseServiceImpl(ConflictCaseRepository repository,ConflictFlagRepository flagRepo) {
        this.repository = repository;
        this.flagRepo = flagRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        return repository.save(conflictCase);
    }

    @Override
    public ConflictCase getCaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict case not found"));
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repository.findByPrimaryPersonIdOrSecondaryPersonId(
                personId, personId);
    }

    @Override
    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase conflictCase = getCaseById(id);
        conflictCase.setStatus(status);
        return repository.save(conflictCase);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repository.findAll();
    }
}
