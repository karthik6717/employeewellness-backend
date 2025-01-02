package com.gk.service;

import java.util.List;

import com.gk.dto.ChallengeRegistrationDto;
import com.gk.dto.EventRegistrationDto;
import com.gk.exception.EmployeeException;

public interface EventRegistrationService {
	
	 // Method to register an employee for a challenge
    boolean registerForEvent(Long employeeId, Long EventId);
    public List<EventRegistrationDto> getRegisteredEventsByEmployeeId(Long employeeId);

	
//	public EventRegistrationDto getEventRegistrationById(Long eventId) throws EmployeeException;
//    public List<EventRegistrationDto> getAllEventRegistration() throws EmployeeException;
//    public EventRegistrationDto addEventRegistration(EventRegistrationDto event) throws EmployeeException;
//    public Long removeEventRegistration(Long eventId) throws EmployeeException;
//    public EventRegistrationDto updateEventRegistation(EventRegistrationDto event) throws EmployeeException;

}
