package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {
    
    private final RelationshipDeclarationService relationshipService;

    public RelationshipDeclarationController(RelationshipDeclarationService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping
    public ResponseEntity<RelationshipDeclaration> declare(@RequestBody RelationshipDeclaration declaration) {
        RelationshipDeclaration saved = relationshipService.declareRelationship(declaration);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}/verify")
    public ResponseEntity<RelationshipDeclaration> verify(@PathVariable Long id, @RequestBody boolean verified) {
        RelationshipDeclaration updated = relationshipService.verifyDeclaration(id, verified);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<RelationshipDeclaration>> getAll() {
        List<RelationshipDeclaration> declarations = relationshipService.getAllDeclarations();
        return ResponseEntity.ok(declarations);
    }
}
