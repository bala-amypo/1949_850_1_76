package com.example.demo.service.impl;

import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonProfileServiceImpl
        implements PersonProfileService {

    private final PersonProfileRepository repository;

    public PersonProfileServiceImpl(PersonProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {
        return repository.save(person);
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return repository.findByReferenceId(referenceId);
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repository.findAll();
    }
}
