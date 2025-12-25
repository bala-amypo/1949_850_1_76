package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflict-flags")
public class ConflictFlagController {

    private final ConflictFlagService service;

    public ConflictFlagController(ConflictFlagService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ConflictFlag> add(@RequestBody ConflictFlag flag) {
        return ResponseEntity.ok(service.addFlag(flag));
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFlagById(id));
    }

    // READ by case
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<ConflictFlag>> byCase(
            @PathVariable Long caseId) {
        return ResponseEntity.ok(service.getFlagsByCase(caseId));
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAll() {
        return ResponseEntity.ok(service.getAllFlags());
    }
}
