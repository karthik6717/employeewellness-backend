package com.gk.dto;

import java.time.LocalDate;
import java.util.List;

import com.gk.entity.EventRegistration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EventDto {
	

	
	public EventDto(String name, LocalDate enrolmentDate, String organizer, LocalDate startDate, LocalDate endDate,
			String eventDescription) {
		super();
		
		this.name = name;
		this.enrolmentDate = enrolmentDate;
		this.Organizer = organizer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.EventDescription = eventDescription;
	}
	private Long eventId;
	private String name;
	private LocalDate enrolmentDate;
	private String Organizer;
	private LocalDate startDate;
	private LocalDate endDate;
	private String EventDescription;
	
	

}
