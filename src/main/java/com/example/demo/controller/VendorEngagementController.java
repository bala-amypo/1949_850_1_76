package com.example.demo.controller;

public class VendorEngagementController {

}
@RestController
@RequestMapping("/api/engagements")
@Tag(name = "Vendor Engagement Controller")
public class VendorEngagementController {
    private final VendorEngagementService service;

    public VendorEngagementController(VendorEngagementService service) {
        this.service = service;
    }

    @PostMapping("/")
    public VendorEngagementRecord add(@RequestBody VendorEngagementRecord record) { return service.addEngagement(record); } [cite: 145]

    @GetMapping("/employee/{employeeId}")
    public List<VendorEngagementRecord> getByEmployee(@PathVariable Long employeeId) { 
        return service.getEngagementsByEmployee(employeeId); [cite: 146]
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorEngagementRecord> getByVendor(@PathVariable Long vendorId) { 
        return service.getEngagementsByVendor(vendorId); [cite: 146]
    }
}