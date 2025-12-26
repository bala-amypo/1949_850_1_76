package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter
public class ConflictCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long primaryPersonId;
    private Long secondaryPersonId;
    private String triggerSource;
    private String riskLevel = "LOW";
    private String status = "OPEN";
}
