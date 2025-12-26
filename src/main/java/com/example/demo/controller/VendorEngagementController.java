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
        return ResponseEntity.ok(engagementService.getEngagementsByEmployee(employeeId));
    }
    
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorEngagementRecord>> getByVendor(@PathVariable Long vendorId) {
        return ResponseEntity.ok(engagementService.getEngagementsByVendor(vendorId));
    }
    
    @GetMapping
    public ResponseEntity<List<VendorEngagementRecord>> getAll() {
        return ResponseEntity.ok(engagementService.getAllEngagements());
    }
}
