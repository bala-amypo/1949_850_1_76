package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter
public class VendorEngagementRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long vendorId;
    private String engagementType;
    private Double amount;
    private LocalDate engagementDate;
}
