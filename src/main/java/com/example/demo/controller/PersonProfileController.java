package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<PersonProfile> create(@RequestBody PersonProfile p) {
        return ResponseEntity.ok(service.createPerson(p));
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPersonById(id));
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAll() {
        return ResponseEntity.ok(service.getAllPersons());
    }

    // LOOKUP by referenceId (used in tests)
    @GetMapping("/lookup/{referenceId}")
    public ResponseEntity<PersonProfile> lookup(@PathVariable String referenceId) {
        return service.findByReferenceId(referenceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE relationshipDeclared
    @PutMapping("/{id}/relationshipDeclared/{value}")
    public ResponseEntity<PersonProfile> updateRelationshipDeclared(
            @PathVariable Long id,
            @PathVariable boolean value) {

        return ResponseEntity.ok(service.updateRelationshipDeclared(id, value));
    }
}
