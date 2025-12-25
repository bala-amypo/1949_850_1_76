package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(RelationshipDeclarationService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<RelationshipDeclaration> declare(
            @RequestBody RelationshipDeclaration declaration) {
        return ResponseEntity.ok(service.declareRelationship(declaration));
    }

    // VERIFY
    @PutMapping("/{id}/verify/{value}")
    public ResponseEntity<RelationshipDeclaration> verify(
            @PathVariable Long id,
            @PathVariable boolean value) {
        return ResponseEntity.ok(service.verifyDeclaration(id, value));
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<RelationshipDeclaration>> getAll() {
        return ResponseEntity.ok(service.getAllDeclarations());
    }
}
