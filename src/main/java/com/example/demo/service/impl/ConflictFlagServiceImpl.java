package com.example.demo.service.impl;

import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository flagRepository;

    // ✅ CORRECT CONSTRUCTOR (only required repo)
    public ConflictFlagServiceImpl(ConflictFlagRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    @Override
    public ConflictFlag createFlag(ConflictFlag flag) {
        return flagRepository.save(flag);
    }

    // ✅ THIS WAS MISSING → CAUSED THE ERROR
    @Override
    public ConflictFlag getFlagById(Long id) {
        return flagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConflictFlag not found"));
    }

    // ✅ Repository method now exists
    @Override
    public List<ConflictFlag> getFlagsByConflictCase(Long conflictCaseId) {
        return flagRepository.findByConflictCaseId(conflictCaseId);
    }
}
