@Entity
public class RelationshipDeclaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private String description;
    private LocalDateTime declaredAt = LocalDateTime.now();
    private Boolean isVerified = false; // Default false [cite: 80, 221]

    public RelationshipDeclaration() {}

    public RelationshipDeclaration(Long personId, String relatedPersonName, String relationshipType, String description) {
        this.personId = personId;
        this.relatedPersonName = relatedPersonName;
        this.relationshipType = relationshipType;
        this.description = description;
        this.isVerified = false;
        this.declaredAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPersonId() { return personId; }
    public void setPersonId(Long personId) { this.personId = personId; }
    public String getRelatedPersonName() { return relatedPersonName; }
    public void setRelatedPersonName(String relatedPersonName) { this.relatedPersonName = relatedPersonName; }
    public String getRelationshipType() { return relationshipType; }
    public void setRelationshipType(String relationshipType) { this.relationshipType = relationshipType; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getDeclaredAt() { return declaredAt; }
    public void setDeclaredAt(LocalDateTime declaredAt) { this.declaredAt = declaredAt; }
    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }
}