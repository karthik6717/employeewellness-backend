package com.gk.service;

import java.util.List;
import com.gk.dto.EventDto;
import com.gk.exception.EmployeeException;

public interface EventService {
	
	public EventDto getEventById(Long eventId) throws EmployeeException;
    public List<EventDto> getAllEvents() throws EmployeeException;
    public EventDto addEvent(EventDto evnt) throws EmployeeException;
    public Long removeEvent(Long eventId) throws EmployeeException;
    public EventDto updateEvent(EventDto evnt) throws EmployeeException;

}
