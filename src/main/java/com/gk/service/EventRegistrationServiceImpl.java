package com.gk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.EmployeeRepository;
import com.gk.dao.EventRegistrationRepository;
import com.gk.dao.EventRepository;
import com.gk.dto.EventRegistrationDto;
import com.gk.entity.Employee;
import com.gk.entity.Event;
import com.gk.entity.EventRegistration;

@Service
@Transactional
public class EventRegistrationServiceImpl  implements EventRegistrationService{

	@Autowired
	private EventRegistrationRepository eventRegRepo;
	
	@Autowired
    private EventRepository eventRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public EventRegistrationServiceImpl(EventRegistrationRepository eventRegRepo,
			EmployeeRepository employeeRepo, EventRepository eventRepo) {
		this.eventRegRepo = eventRegRepo;
		this.employeeRepository = employeeRepo;
		this.eventRepository = eventRepo;
	}
    

    @Override
    public boolean registerForEvent(Long employeeId, Long eventId) {
    	 // Check if the challenge and employee combination already exists
        if (eventRegRepo.existsByEventIdAndEmployeeId(eventId, employeeId)) 
        {
            // Registration already exists
            return false;
        }

        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        Optional<Event> eventOpt = eventRepository.findById(eventId);

        // Check if both employee and challenge exist
        if (employeeOpt.isPresent() && eventOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            Event event = eventOpt.get();

            // Create a new ChallengeRegistration entry (if you have a ChallengeRegistration entity)
            EventRegistration registration = new EventRegistration();
            registration.setEmployee(employee);
            registration.setEvent(event);

            // Save the new registration
            eventRegRepo.save(registration);
            return true;
        }
        return false;
    }


	@Override
	public List<EventRegistrationDto> getRegisteredEventsByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		List<Event> events = eventRegRepo.findEventsByEmployeeId(employeeId);
		List<EventRegistrationDto> result = new ArrayList<>();

		// Convert entities to DTOs
		return events.stream()
				.map(event -> new EventRegistrationDto(event.getEventId(), event.getName(),
						event.getEnrolmentDate(), event.getOrganizer(), event.getStartDate(),event.getEndDate(), event.getEventDescription())).collect(Collectors.toList()) ;
	}
	
	
	
	
	
	
//	@Override
//	public EventRegistrationDto getEventRegistrationById(Long eventId) throws EmployeeException {
//		// TODO Auto-generated method stub
//		try {
//            Optional<EventRegistration> eventR= eventRegistrationRepo.findById(eventId);
//            if(eventR.isPresent()) {
//                return EventRegistrationUtils.EntityToDto(eventR.get());
//            }else {
//                throw new EmployeeException("Invalid Event Registration id");
//            }
//            
//        }catch(DataAccessException e) {
//            throw new EmployeeException(e.getMessage(),e);
//        }catch(Exception e) {
//            throw new EmployeeException(e.getMessage(),e);
//        }
//		
//	}
//
//	@Override
//	public List<EventRegistrationDto> getAllEventRegistration() throws EmployeeException {
//		// TODO Auto-generated method stub
//		try {
//            List<EventRegistration> eventRegList= eventRegistrationRepo.findAll();
//           if(eventRegList.size() != 0) {
//               return EventRegistrationUtils.EntityToDtoList(eventRegList);
//           }else {
//               throw new EmployeeException("No data");
//           }
//           
//       }catch(DataAccessException e) {
//           throw new EmployeeException(e.getMessage(),e);
//       }catch(Exception e) {
//           throw new EmployeeException(e.getMessage(),e);
//       }
//		
//		
//	}
//
//	@Override
//	public EventRegistrationDto addEventRegistration(EventRegistrationDto event) throws EmployeeException {
//		// TODO Auto-generated method stub
//		
//		try {
//			EventRegistration eventReg1= eventRegistrationRepo.save(EventRegistrationUtils.dtoTOEntity(event));
//		
//            return EventRegistrationUtils.EntityToDto(eventReg1);            
//        }catch(DataAccessException e) {
//            throw new EmployeeException(e.getMessage(),e);
//        }
//	}
//
//	@Override
//	public Long removeEventRegistration(Long eventId) throws EmployeeException {
//		try {
//			
//            Optional<EventRegistration> eventReg= eventRegistrationRepo.findById(eventId);
//            eventRegistrationRepo.deleteById(eventId);
//            
//            if(!eventReg.isPresent()) {
//              return eventId;    
//            }else {
//                throw new EmployeeException("Unable to delete");
//            }
//        }catch(DataAccessException e) {
//            throw new EmployeeException(e.getMessage(),e);
//        }catch(Exception e) {
//            throw new EmployeeException(e.getMessage(),e);
//        }
//	}
//
//	@Override
//	public EventRegistrationDto updateEventRegistation(EventRegistrationDto event) throws EmployeeException {
//try {
//			
//		EventRegistration updatedEvent= eventRegistrationRepo.save(EventRegistrationUtils.dtoTOEntity(event));
//         return EventRegistrationUtils.EntityToDto(updatedEvent);            
//        }catch(DataAccessException e) {
//            throw new EmployeeException(e.getMessage(),e);
//        }
//	}

}
