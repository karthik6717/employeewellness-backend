package com.gk.dto;




import java.time.LocalDate;

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
	public class EventRegistrationDto {
		
		
		public EventRegistrationDto(Long eventId, String name, LocalDate enrolmentDate, String organizer,
				LocalDate startDate, LocalDate endDate, String EventDescription) {
			super();
			this.eventId = eventId;
			this.name = name;
			this.enrolmentDate = enrolmentDate;
			this.Organizer = organizer;
			this.startDate = startDate;
			this.endDate = endDate;
			this.EventDescription = EventDescription;
		}
		private Long eventRegistrationId;
		private Long employeeId;
		
		
		private Long eventId;
	    private String name;
		private LocalDate enrolmentDate;
		private String Organizer;
		private LocalDate startDate;
		private LocalDate endDate;
		private String EventDescription;
		
		
		

}
