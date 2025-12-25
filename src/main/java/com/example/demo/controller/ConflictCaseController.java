package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-cases")
public class ConflictCaseController {

    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ConflictCase> create(@RequestBody ConflictCase c) {
        return ResponseEntity.ok(service.createCase(c));
    }

    // UPDATE status
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<ConflictCase> updateStatus(
            @PathVariable Long id,
            @PathVariable String status) {
        return ResponseEntity.ok(service.updateCaseStatus(id, status));
    }

    // READ by person
    @GetMapping("/person/{personId}")
    public ResponseEntity<List<ConflictCase>> byPerson(
            @PathVariable Long personId) {
        return ResponseEntity.ok(service.getCasesByPerson(personId));
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAll() {
        return ResponseEntity.ok(service.getAllCases());
    }
}
