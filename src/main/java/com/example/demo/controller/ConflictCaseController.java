package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conflict-cases")
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
        ConflictCase updated = caseService.updateCaseStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<ConflictCase>> getByPerson(@PathVariable Long personId) {
        List<ConflictCase> cases = caseService.getCasesByPerson(personId);
        return ResponseEntity.ok(cases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictCase> getById(@PathVariable Long id) {
        ConflictCase caseObj = caseService.getCaseById(id);
        return ResponseEntity.ok(caseObj);
    }

    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAll() {
        List<ConflictCase> cases = caseService.getAllCases();
        return ResponseEntity.ok(cases);
    }
}
