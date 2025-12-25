package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repo;
    private final ConflictFlagRepository flagRepo;

    public ConflictCaseServiceImpl(ConflictCaseRepository repo,
                                   ConflictFlagRepository flagRepo) {
        this.repo = repo;
        this.flagRepo = flagRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {

        if (conflictCase.getStatus() == null) {
            conflictCase.setStatus("OPEN");
        }

        return repo.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long caseId, String status) {

        ConflictCase c = repo.findById(caseId)
                .orElseThrow(() -> new ApiException("Case not found"));

        c.setStatus(status);
        return repo.save(c);
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repo.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repo.findAll();
    }
}