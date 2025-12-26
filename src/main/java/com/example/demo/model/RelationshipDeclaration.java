package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RelationshipDeclaration {
z
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Person who declares the relationship
     * (linked manually in service layer)
     */
    private Long personId;

    private String relatedPersonName;

    private String relationshipType;

    /**
     * IMPORTANT:
     * - Must default to FALSE
     * - Tests explicitly check verification toggle
     */
    private Boolean isVerified = false;

    // ----------------- Getters & Setters -----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getRelatedPersonName() {
        return relatedPersonName;
    }

    public void setRelatedPersonName(String relatedPersonName) {
        this.relatedPersonName = relatedPersonName;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean verified) {
        isVerified = verified;
    }
}
