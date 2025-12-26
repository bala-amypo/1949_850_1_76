package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flags")
public class ConflictFlagController {
    
    private final ConflictFlagService flagService;
    
    public ConflictFlagController(ConflictFlagService flagService) {
        this.flagService = flagService;
    }
    
    @PostMapping
    public ResponseEntity<ConflictFlag> addFlag(@RequestBody ConflictFlag flag) {
        ConflictFlag saved = flagService.addFlag(flag);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<ConflictFlag>> getByCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(flagService.getFlagsByCase(caseId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getById(@PathVariable Long id) {
        try {
            ConflictFlag flag = flagService.getFlagById(id);
            return ResponseEntity.ok(flag);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAll() {
        return ResponseEntity.ok(flagService.getAllFlags());
    }
}
