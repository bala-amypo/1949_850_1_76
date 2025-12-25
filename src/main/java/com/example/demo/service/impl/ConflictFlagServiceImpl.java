package com.example.demo.service.impl;

import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository flagRepository;
    private final ConflictCaseRepository caseRepository;

    // ✅ FIXED CONSTRUCTOR (matches test expectations)
    public ConflictFlagServiceImpl(ConflictFlagRepository flagRepository,
                                   ConflictCaseRepository caseRepository) {
        this.flagRepository = flagRepository;
        this.caseRepository = caseRepository;
    }

    @Override
    public ConflictFlag createFlag(ConflictFlag flag) {
        return flagRepository.save(flag);
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return flagRepository.findAll();
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return flagRepository.findByConflictCaseId(caseId);
    }
}
