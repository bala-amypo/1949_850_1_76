package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engagements")
public class VendorEngagementController {

    private final VendorEngagementService service;

    public VendorEngagementController(VendorEngagementService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<VendorEngagementRecord> create(
            @RequestBody VendorEngagementRecord record) {
        return ResponseEntity.ok(service.addEngagement(record));
    }

    // READ by employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<VendorEngagementRecord>> byEmployee(
            @PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getEngagementsByEmployee(employeeId));
    }

    // READ by vendor
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorEngagementRecord>> byVendor(
            @PathVariable Long vendorId) {
        return ResponseEntity.ok(service.getEngagementsByVendor(vendorId));
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<VendorEngagementRecord>> getAll() {
        return ResponseEntity.ok(service.getAllEngagements());
    }
}
