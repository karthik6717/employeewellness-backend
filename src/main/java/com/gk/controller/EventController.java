package com.gk.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.gk.dto.EventDto;
import com.gk.exception.EmployeeException;
import com.gk.service.EventServiceImpl;

@RestController
@RequestMapping("/api/employeewellness/events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    // Get event details by ID
    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long eventId) {
        try {
            EventDto event = eventService.getEventById(eventId);
            return ResponseEntity.ok(event);
        } catch (EmployeeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // Get all events
    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        try {
            List<EventDto> events = eventService.getAllEvents();
            return ResponseEntity.ok(events);
        } catch (EmployeeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // Add a new event
    @PostMapping
    public ResponseEntity<String> addEvent(@RequestBody EventDto eventDto) {
        try {
            eventService.addEvent(eventDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Event added successfully.");
        } catch (EmployeeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // Remove an event by ID
    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> removeEvent(@PathVariable Long eventId) {
        try {
            eventService.removeEvent(eventId);
            return ResponseEntity.ok("Event deleted successfully.");
        } catch (EmployeeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    // Update an event
    @PutMapping("/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable Long eventId, @RequestBody EventDto eventDto) {
        try {
            eventDto.setEventId(eventId); // Ensure event ID is set for updating
            eventService.updateEvent(eventDto);
            return ResponseEntity.ok("Event updated successfully.");
        } catch (EmployeeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
