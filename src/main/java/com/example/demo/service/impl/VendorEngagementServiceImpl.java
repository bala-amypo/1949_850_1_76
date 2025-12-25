package com.example.demo.service.impl;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorEngagementServiceImpl
        implements VendorEngagementService {

    private final VendorEngagementRecordRepository repository;
    private final PersonProfileRepository personRepo;


    public VendorEngagementServiceImpl(
            VendorEngagementRecordRepository repository, PersonProfileRepository personRepo) {
        this.repository = repository;
        this.personRepo = personRepo;
    }

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {
        return repository.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return repository.findAll();
    }
}


