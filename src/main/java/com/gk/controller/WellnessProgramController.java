package com.gk.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.dto.WellnessProgramDto;
import com.gk.entity.ProgramType;
import com.gk.exception.EmployeeException;
import com.gk.service.WellnessProgramServiceImpl;

@RestController
@RequestMapping("/api/wellnessprogram")
public class WellnessProgramController {

    @Autowired
    private WellnessProgramServiceImpl wellnessProgramService;

    // Get Wellness Program by ID
    @GetMapping("/getWellnessById/{wellId}")
    public ResponseEntity<WellnessProgramDto> getWellnessById(@PathVariable Long wellId) {
        try {
            WellnessProgramDto wellnessProgram = wellnessProgramService.getWellnessProgramId(wellId);
            if (wellnessProgram != null) {
                return ResponseEntity.ok(wellnessProgram);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Get all wellness programs
    @GetMapping("/getAllWellness")
    public ResponseEntity<List<WellnessProgramDto>> getAllWellness(@RequestParam String empId) throws EmployeeException {
        List<WellnessProgramDto> wellnessList = wellnessProgramService.getAllWellnessProgram();
        return ResponseEntity.ok(wellnessList);
    }

    // Add a new wellness program
    @PostMapping("/addWell")
    public ResponseEntity<String> addWellnessProgram(@RequestBody WellnessProgramDto wellnessProgramDto) {
        try {
            WellnessProgramDto savedProgram = wellnessProgramService.addWellnessProgram(wellnessProgramDto);
            if (savedProgram != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Wellness Program Added");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wellness Program Not Added");
            }
        } catch (EmployeeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    // Remove a wellness program by ID using @DeleteMapping
    @DeleteMapping("/removeWellness/{wellId}")
    public ResponseEntity<String> removeWellnessProgram(@PathVariable Long wellId) {
        try {
            wellnessProgramService.removeWellnessProgram(wellId);
            return ResponseEntity.ok("Wellness Program is Deleted");
        } catch (EmployeeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    // Update a wellness program by ID using @PutMapping
    @PutMapping("/updateWellness")
    public ResponseEntity<String> updateWellnessProgram(@RequestBody WellnessProgramDto wellnessProgramDto) {
        try {
            WellnessProgramDto updatedProgram = wellnessProgramService.updateWellnessProgram(wellnessProgramDto);
            if (updatedProgram != null) {
                return ResponseEntity.ok("Wellness Program updated");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Wellness Program is Not updated");
            }
        } catch (EmployeeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}
