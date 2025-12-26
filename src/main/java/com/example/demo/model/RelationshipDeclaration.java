package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "relationship_declaration")
public class RelationshipDeclaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "person_id")
    private Long personId;
    
    @Column(name = "related_person_name")
    private String relatedPersonName;
    
    @Column(name = "relationship_type")
    private String relationshipType;
    
    @Column(name = "is_verified")
    private Boolean isVerified = false;
    
    // Constructors
    public RelationshipDeclaration() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPersonId() { return personId; }
    public void setPersonId(Long personId) { this.personId = personId; }
    
    public String getRelatedPersonName() { return relatedPersonName; }
    public void setRelatedPersonName(String relatedPersonName) { this.relatedPersonName = relatedPersonName; }
    
    public String getRelationshipType() { return relationshipType; }
    public void setRelationshipType(String relationshipType) { this.relationshipType = relationshipType; }
    
    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }
}
