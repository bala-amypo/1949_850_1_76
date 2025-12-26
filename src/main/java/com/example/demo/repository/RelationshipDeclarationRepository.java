package com.example.demo.repository;

import com.example.demo.model.RelationshipDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipDeclarationRepository extends JpaRepository<RelationshipDeclaration, Long> {
}
