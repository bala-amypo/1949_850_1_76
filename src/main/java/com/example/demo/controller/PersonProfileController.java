package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PersonProfile createPerson(@RequestBody PersonProfile person) {
        return service.createPerson(person);
    }

    @GetMapping("/{id}")
    public PersonProfile getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @GetMapping
    public List<PersonProfile> getAllPersons() {
        return service.getAllPersons();
    }

    @PutMapping("/{id}/relationship")
    public PersonProfile updateRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {
        return service.updateRelationshipDeclared(id, declared);
    }

    @GetMapping("/reference/{refId}")
    public PersonProfile getByReferenceId(@PathVariable String refId) {
        return service.findByReferenceId(refId);
    }
}
