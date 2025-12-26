package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_profile")
public class PersonProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String referenceId;
    private String fullName;
    private String personType;
    private String department;
    
    @Column(name = "relationship_declared")
    private Boolean relationshipDeclared = false;
    
    // Constructors
    public PersonProfile() {}
    
    public PersonProfile(Long id, String email, String referenceId, String fullName, String personType) {
        this.id = id;
        this.email = email;
        this.referenceId = referenceId;
        this.fullName = fullName;
        this.personType = personType;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getPersonType() { return personType; }
    public void setPersonType(String personType) { this.personType = personType; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public Boolean getRelationshipDeclared() { return relationshipDeclared; }
    public void setRelationshipDeclared(Boolean relationshipDeclared) { 
        this.relationshipDeclared = relationshipDeclared; 
    }
}
