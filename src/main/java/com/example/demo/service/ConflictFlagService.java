package com.example.demo.service;

import com.example.demo.model.ConflictFlag;

import java.util.List;

public interface ConflictFlagService {

    ConflictFlag createFlag(ConflictFlag flag);

    ConflictFlag getFlagById(Long id);

    List<ConflictFlag> getFlagsByConflictCase(Long conflictCaseId);
}
