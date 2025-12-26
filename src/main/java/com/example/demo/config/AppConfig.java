package com.example.demo.config;

import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.impl.ConflictCaseServiceImpl;
import com.example.demo.service.impl.ConflictFlagServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @Bean
    public ConflictCaseServiceImpl conflictCaseService(ConflictCaseRepository caseRepo, ConflictFlagRepository flagRepo) {
        return new ConflictCaseServiceImpl(caseRepo, flagRepo);
    }
    
    @Bean
    public ConflictFlagServiceImpl conflictFlagService(ConflictFlagRepository flagRepo, ConflictCaseRepository caseRepo) {
        return new ConflictFlagServiceImpl(flagRepo, caseRepo);
    }
}
