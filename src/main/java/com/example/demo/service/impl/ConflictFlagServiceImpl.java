package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ConflictFlagServiceImpl implements ConflictFlagService {
    private final ConflictFlagRepository flagRepo;
    private final ConflictCaseRepository caseRepo;
    
    public ConflictFlagServiceImpl(ConflictFlagRepository flagRepo, ConflictCaseRepository caseRepo) {
        this.flagRepo = flagRepo;
        this.caseRepo = caseRepo;
    }
    
    @Override
    public ConflictFlag addFlag(ConflictFlag flag) {
        caseRepo.findById(flag.getCaseId())
                .orElseThrow(() -> new ApiException("Conflict case not found"));
        
        ConflictCase conflictCase = caseRepo.findById(flag.getCaseId()).get();
        if ("HIGH".equals(flag.getSeverity()) && "LOW".equals(conflictCase.getRiskLevel())) {
            conflictCase.setRiskLevel("HIGH");
            caseRepo.save(conflictCase);
        }
        
        return flagRepo.save(flag);
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
