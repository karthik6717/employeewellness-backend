package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.EventRepository;
import com.gk.dto.EventDto;

import com.gk.entity.Event;
import com.gk.exception.EmployeeException;

import com.gk.utils.EventUtils;



@Service
@Transactional
public class EventServiceImpl implements EventService{
	
	
	@Autowired
	private EventRepository eventRepo;

	@Override
	public EventDto getEventById(Long eventId) throws EmployeeException {
		// TODO Auto-generated method stub
		
            Optional<Event> evnt= eventRepo.findById(eventId);
            if(evnt.isPresent())
            {
                return EventUtils.EntityToDto(evnt.get());
            }
            else 
            {
                throw new EmployeeException("Invalid event id");
            }
            
       
	
	}

	@Override
	public List<EventDto> getAllEvents() throws EmployeeException {
		// TODO Auto-generated method stub
		
	
			List<Event> eventList = eventRepo.findAll();
			if(eventList.size()!=0)
			{
				return EventUtils.EntityToDtoList(eventList);
			}
			else
			{
				throw new EmployeeException("No data");
			}
		

		}
	
	

	@Override
	public EventDto addEvent(EventDto evnt) throws EmployeeException {
		// TODO Auto-generated method stub
		
		
			Event evnt1 = eventRepo.save(EventUtils.dtoTOEntity(evnt));
		
            return EventUtils.EntityToDto(evnt1);            
       
	
	}

	@Override
	public Long removeEvent(Long eventId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		
			  eventRepo.deleteById(eventId);
            Optional<Event> note= eventRepo.findById(eventId);
          
            if(!note.isPresent())
            {
              return eventId;    
            }
            else
            {
                throw new EmployeeException("Unable to delete");
            }
       
	
	}

	@Override
	public EventDto updateEvent(EventDto evnt) throws EmployeeException
	    {
		// TODO Auto-generated method stub
	
			Event updatedEvent= eventRepo.save(EventUtils.dtoTOEntity(evnt));
            return EventUtils.EntityToDto(updatedEvent);            
        }
        
	
	

}
