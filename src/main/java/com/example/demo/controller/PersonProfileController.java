package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PersonProfile create(@RequestBody PersonProfile person) {
        return service.createPerson(person);
    }

    @GetMapping("/reference/{refId}")
    public ResponseEntity<PersonProfile> getPersonByReference(
            @PathVariable String refId) {

        return service.findByReferenceId(refId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PersonProfile> getAll() {
        return service.getAllPersons();
    }
}
