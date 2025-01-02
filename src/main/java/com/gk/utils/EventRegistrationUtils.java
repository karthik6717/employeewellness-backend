package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.gk.dto.EmployeeDto;
import com.gk.dto.EventRegistrationDto;
import com.gk.entity.Employee;
import com.gk.entity.EventRegistration;

public class EventRegistrationUtils {
	public static ModelMapper mapper = new ModelMapper();
	
	static {
        // Configure the mapping explicitly to resolve ambiguity
        mapper.addMappings(new PropertyMap<EventRegistration, EventRegistrationDto>() {
            @Override
            protected void configure() {
                map().setEventId(source.getEvent().getEventId());
                map().setEmployeeId(source.getEmployee().getEmployeeId());
            }
        });
    }
	
	public static EventRegistration dtoTOEntity(EventRegistrationDto event)
	{
		return mapper.map(event,EventRegistration.class);
	}
	
	public static EventRegistrationDto EntityToDto(EventRegistration event)
	{
		return mapper.map(event,EventRegistrationDto.class);
	}
	public static List<EventRegistrationDto> EntityToDtoList(List<EventRegistration> event)
	{
		List<EventRegistrationDto> resList = new ArrayList<>();
		event.forEach(e-> resList.add(EntityToDto(e)));
		return resList;
	}

}
