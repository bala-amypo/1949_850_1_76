@Entity
public class VendorEngagementRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Long vendorId;
    private String engagementType;
    private Double amount;
    private java.time.LocalDate engagementDate;
    private String notes;

    public VendorEngagementRecord() {}

    public VendorEngagementRecord(Long employeeId, Long vendorId, String engagementType, Double amount, java.time.LocalDate engagementDate, String notes) {
        this.employeeId = employeeId;
        this.vendorId = vendorId;
        this.engagementType = engagementType;
        this.amount = amount;
        this.engagementDate = engagementDate;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }
    public String getEngagementType() { return engagementType; }
    public void setEngagementType(String engagementType) { this.engagementType = engagementType; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public java.time.LocalDate getEngagementDate() { return engagementDate; }
    public void setEngagementDate(java.time.LocalDate engagementDate) { this.engagementDate = engagementDate; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}