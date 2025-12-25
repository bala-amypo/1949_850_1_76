package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;
    private final PersonProfileRepository personRepo;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository repo,
                                              PersonProfileRepository personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {

        PersonProfile person = personRepo.findById(declaration.getPersonId())
                .orElseThrow(() -> new ApiException("Person not found"));

        person.setRelationshipDeclared(true);
        personRepo.save(person);

        return repo.save(declaration);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {

        RelationshipDeclaration declaration = repo.findById(id)
                .orElseThrow(() -> new ApiException("Declaration not found"));

        declaration.setIsVerified(verified);
        return repo.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repo.findAll();
    }
}