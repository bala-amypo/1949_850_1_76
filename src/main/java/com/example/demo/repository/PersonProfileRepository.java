package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface PersonProfileRepository extends JpaRepository<PersonProfile, Long> {
    Optional<PersonProfile> findByEmail(String email); [cite: 49, 287]
    Optional<PersonProfile> findByReferenceId(String refId); [cite: 50, 288]
}

public interface RelationshipDeclarationRepository extends JpaRepository<RelationshipDeclaration, Long> {
    List<RelationshipDeclaration> findByPersonId(Long personId); [cite: 348]
}

public interface VendorEngagementRecordRepository extends JpaRepository<VendorEngagementRecord, Long> {
    List<VendorEngagementRecord> findByEmployeeId(Long id); [cite: 51, 296]
    List<VendorEngagementRecord> findByVendorId(Long id); [cite: 52, 297]
}

public interface ConflictCaseRepository extends JpaRepository<ConflictCase, Long> {
    List<ConflictCase> findByPrimaryPersonIdOrSecondaryPersonId(Long id1, Long id2); [cite: 53, 300]
}

public interface ConflictFlagRepository extends JpaRepository<ConflictFlag, Long> {
    List<ConflictFlag> findByCaseId(Long id); [cite: 55, 304]
}