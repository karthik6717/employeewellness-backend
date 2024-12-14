package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.gk.dto.EventDto;
import com.gk.entity.Event;



public class EventUtils {
	public static ModelMapper mapper = new ModelMapper();
	
	public static Event dtoTOEntity(EventDto emp)
	{
		return mapper.map(emp,Event.class);
	}
	
	public static EventDto EntityToDto(Event emp)
	{
		return mapper.map(emp,EventDto.class);
	}
	public static List< EventDto> EntityToDtoList(List<Event> emp)
	{
		List<EventDto> resList = new ArrayList<>();
		emp.forEach(e-> resList.add(EntityToDto(e)));
		return resList;
	}

}
