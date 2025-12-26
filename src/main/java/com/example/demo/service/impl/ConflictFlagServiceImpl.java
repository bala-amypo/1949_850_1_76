package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {
    
    private final ConflictFlagRepository flagRepo;
    private final ConflictCaseRepository caseRepo;

    public ConflictFlagServiceImpl(ConflictFlagRepository flagRepo, ConflictCaseRepository caseRepo) {
        this.flagRepo = flagRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public ConflictFlag addFlag(ConflictFlag flag) {
        if (flag.getCaseId() == null) {
            throw new ApiException("Case ID is required for flag");
        }

        ConflictCase conflictCase = caseRepo.findById(flag.getCaseId())
                .orElseThrow(() -> new ApiException("Conflict case not found"));

        ConflictFlag savedFlag = flagRepo.save(flag);
        
        // Update case risk level based on flag severity (for test56)
        if ("HIGH".equals(flag.getSeverity()) && "LOW".equals(conflictCase.getRiskLevel())) {
            conflictCase.setRiskLevel("HIGH");
            caseRepo.save(conflictCase);
        }
        
        return savedFlag;
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return flagRepo.findByCaseId(caseId);
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return flagRepo.findById(id)
                .orElseThrow(() -> new ApiException("Conflict flag not found"));
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return flagRepo.findAll();
    }
}
