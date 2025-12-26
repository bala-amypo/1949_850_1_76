package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {
    
    private final PersonProfileRepository personRepo;

    public PersonProfileServiceImpl(PersonProfileRepository personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {
        if (person.getEmail() == null || person.getEmail().trim().isEmpty()) {
            throw new ApiException("Email is required");
        }
        if (person.getReferenceId() == null || person.getReferenceId().trim().isEmpty()) {
            throw new ApiException("Reference ID is required");
        }

        Optional<PersonProfile> existingByEmail = personRepo.findByEmail(person.getEmail());
        if (existingByEmail.isPresent()) {
            throw new ApiException("Email already exists");
        }

        Optional<PersonProfile> existingByRefId = personRepo.findByReferenceId(person.getReferenceId());
        if (existingByRefId.isPresent()) {
            throw new ApiException("Reference ID already exists");
        }

        return personRepo.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return personRepo.findById(id)
                .orElseThrow(() -> new ApiException("Person not found"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return personRepo.findByReferenceId(referenceId);
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile person = personRepo.findById(id)
                .orElseThrow(() -> new ApiException("Person not found"));
        person.setRelationshipDeclared(declared);
        return personRepo.save(person);
    }
}
