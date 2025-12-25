package com.example.demo.repository;

import com.example.demo.model.PersonProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonProfileRepository
        extends JpaRepository<PersonProfile, Long> {

    Optional<PersonProfile> findByReferenceId(String referenceId);
}