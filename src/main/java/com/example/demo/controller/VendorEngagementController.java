package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engagements")
public class VendorEngagementController {
    
    private final VendorEngagementService engagementService;

    public VendorEngagementController(VendorEngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @PostMapping
    public ResponseEntity<VendorEngagementRecord> addEngagement(@RequestBody VendorEngagementRecord record) {
        VendorEngagementRecord saved = engagementService.addEngagement(record);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<VendorEngagementRecord>> getByEmployee(@PathVariable Long employeeId) {
        List<VendorEngagementRecord> engagements = engagementService.getEngagementsByEmployee(employeeId);
        return ResponseEntity.ok(engagements);
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorEngagementRecord>> getByVendor(@PathVariable Long vendorId) {
        List<VendorEngagementRecord> engagements = engagementService.getEngagementsByVendor(vendorId);
        return ResponseEntity.ok(engagements);
    }

    @GetMapping
    public ResponseEntity<List<VendorEngagementRecord>> getAll() {
        List<VendorEngagementRecord> engagements = engagementService.getAllEngagements();
        return ResponseEntity.ok(engagements);
    }
}
