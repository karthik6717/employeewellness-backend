package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.gk.dto.EventRegistrationDto;
import com.gk.exception.EmployeeException;
import com.gk.service.EventRegistrationServiceImpl;

@RestController
@RequestMapping("/api/eventRegistration")
@CrossOrigin("*")
public class EventRegistrationController {

    @Autowired
    private EventRegistrationServiceImpl eventRegService;

    // Register an employee for an event
    @PostMapping("/{employeeId}/{eventId}")
    public ResponseEntity<String> registerForEvent(@PathVariable Long employeeId, @PathVariable Long eventId) {
        boolean success = eventRegService.registerForEvent(employeeId, eventId);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee successfully registered for the event.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Registration failed. Employee may already be registered or an error occurred.");
        }
    }

    // Get all registered events for an employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EventRegistrationDto>> getRegisteredEvents(@PathVariable Long employeeId) {
        List<EventRegistrationDto> registeredEvents = eventRegService.getRegisteredEventsByEmployeeId(employeeId);
		return ResponseEntity.ok(registeredEvents);
    }

//    // Get event registration by ID
//    @GetMapping("/{eventRegId}")
//    public ResponseEntity<EventRegistrationDto> getEventRegistrationById(@PathVariable Long eventRegId) {
//        try {
//            EventRegistrationDto eventRegistration = eventRegService.getEventRegistrationById(eventRegId);
//            return ResponseEntity.ok(eventRegistration);
//        } catch (EmployeeException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }
//
//    // Get all event registrations
//    @GetMapping
//    public ResponseEntity<List<EventRegistrationDto>> getAllEventRegistrations() {
//        try {
//            List<EventRegistrationDto> eventRegistrations = eventRegService.getAllEventRegistration();
//            return ResponseEntity.ok(eventRegistrations);
//        } catch (EmployeeException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }
//
//    // Add a new event registration
//    @PostMapping
//    public ResponseEntity<EventRegistrationDto> addEventRegistration(@RequestBody EventRegistrationDto eventRegistrationDto) {
//        try {
//            EventRegistrationDto createdRegistration = eventRegService.addEventRegistration(eventRegistrationDto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdRegistration);
//        } catch (EmployeeException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }
//
//    // Remove an event registration by ID
//    @DeleteMapping("/{eventRegId}")
//    public ResponseEntity<String> removeEventRegistration(@PathVariable Long eventRegId) {
//        try {
//            eventRegService.removeEventRegistration(eventRegId);
//            return ResponseEntity.ok("Event registration removed successfully.");
//        } catch (EmployeeException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }
//
//    // Update an existing event registration
//    @PutMapping
//    public ResponseEntity<EventRegistrationDto> updateEventRegistration(@RequestBody EventRegistrationDto eventRegistrationDto) {
//        try {
//            EventRegistrationDto updatedRegistration = eventRegService.updateEventRegistation(eventRegistrationDto);
//            return ResponseEntity.ok(updatedRegistration);
//        } catch (EmployeeException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//    }
}
