package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@Tag(name = "Person Profile Controller")
public class PersonProfileController {
    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) { [cite: 383]
        this.service = service;
    }

    @PostMapping("/")
    public PersonProfile createPerson(@RequestBody PersonProfile person) { return service.createPerson(person); } [cite: 135]

    @GetMapping("/{id}")
    public PersonProfile getPersonById(@PathVariable Long id) { return service.getPersonById(id); } [cite: 136]

    @GetMapping("/")
    public List<PersonProfile> getAllPersons() { return service.getAllPersons(); } [cite: 137]

    @PutMapping("/{id}/relationship-declared")
    public PersonProfile updateFlag(@PathVariable Long id, @RequestParam boolean declared) {
        return service.updateRelationshipDeclared(id, declared); [cite: 138]
    }

    @GetMapping("/lookup/{referenceId}")
    public PersonProfile getByRef(@PathVariable String referenceId) { return service.findByReferenceId(referenceId); } [cite: 139]
}