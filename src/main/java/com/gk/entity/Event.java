package com.gk.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "EmployeeWellness_batch2_Event_karthikg")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eventId;
	
	private String name;
	private LocalDate enrolmentDate;
	private String Organizer;
	private LocalDate startDate;
	private LocalDate endDate;
	private String EventDescription;
	
	//mappings
	
	@OneToMany(mappedBy="event",cascade=CascadeType.ALL)
	private List<EventRegistration> employeeEvent;
	

}