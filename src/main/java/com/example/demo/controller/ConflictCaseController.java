package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class ConflictCaseController {
    
    private final ConflictCaseService caseService;
    
    public ConflictCaseController(ConflictCaseService caseService) {
        this.caseService = caseService;
    }
    
    @PostMapping
    public ResponseEntity<ConflictCase> createCase(@RequestBody ConflictCase conflictCase) {
        ConflictCase saved = caseService.createCase(conflictCase);
        return ResponseEntity.ok(saved);
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<ConflictCase> updateStatus(@PathVariable Long id, @RequestParam String status) {
        try {
            ConflictCase updated = caseService.updateCaseStatus(id, status);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/person/{personId}")
    public ResponseEntity<List<ConflictCase>> getByPerson(@PathVariable Long personId) {
        return ResponseEntity.ok(caseService.getCasesByPerson(personId));
    }
    
    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAll() {
        return ResponseEntity.ok(caseService.getAllCases());
    }
}
