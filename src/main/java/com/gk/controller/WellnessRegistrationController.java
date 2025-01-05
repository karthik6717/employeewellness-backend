package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.dto.WellnessRegistrationDto;
import com.gk.service.WellnessRegistrationServiceImpl;

@RestController
@RequestMapping("/wellnessRegistration")
@CrossOrigin("*")
public class WellnessRegistrationController {

    @Autowired
    private WellnessRegistrationServiceImpl wellReg;

    // Method to register an employee for a wellness program
    @GetMapping("/register/{employeeId}/{wellnessProgramId}")
    public ResponseEntity<String> registerForWellnessProgram(@PathVariable("employeeId") Long employeeId, 
                                                             @PathVariable("wellnessProgramId") Long wellnessProgramId) {
        boolean success = wellReg.registerForWellnessProgram(employeeId, wellnessProgramId);

        if (success) {
            return new ResponseEntity<>("Employee successfully registered for the wellness program.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Registration failed. Employee may already be registered or an error occurred.", HttpStatus.BAD_REQUEST);
        }
    }

    // Method to get all wellness programs registered by an employee
    @GetMapping("/registeredWellnessPrograms/{employeeId}")
    public ResponseEntity<List<WellnessRegistrationDto>> getRegisteredWellnessPrograms(@PathVariable("employeeId") Long employeeId) {
        List<WellnessRegistrationDto> registeredWellness = wellReg.getRegisteredWellnessByEmployeeId(employeeId);

        if (registeredWellness.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No content found
        }

        return new ResponseEntity<>(registeredWellness, HttpStatus.OK);  // Return the list of registered wellness programs
    }
}
