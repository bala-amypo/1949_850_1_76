@Entity
public class ConflictFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long caseId;
    private String flagType;
    private String description;
    private String severity;
    private LocalDateTime flaggedAt = LocalDateTime.now();

    public ConflictFlag() {}

    public ConflictFlag(Long caseId, String flagType, String description, String severity) {
        this.caseId = caseId;
        this.flagType = flagType;
        this.description = description;
        this.severity = severity;
        this.flaggedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCaseId() { return caseId; }
    public void setCaseId(Long caseId) { this.caseId = caseId; }
    public String getFlagType() { return flagType; }
    public void setFlagType(String flagType) { this.flagType = flagType; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public LocalDateTime getFlaggedAt() { return flaggedAt; }
    public void setFlaggedAt(LocalDateTime flaggedAt) { this.flaggedAt = flaggedAt; }
}