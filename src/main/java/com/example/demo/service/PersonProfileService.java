package com.example.demo.service;

import com.example.demo.model.PersonProfile;

import java.util.List;
import java.util.Optional;

public interface PersonProfileService {

    PersonProfile createPerson(PersonProfile person);

    Optional<PersonProfile> findByReferenceId(String referenceId);

    List<PersonProfile> getAllPersons();
}
