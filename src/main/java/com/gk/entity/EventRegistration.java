package com.gk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "EmployeeWellness_batch2_EventRegistration_karthikg")
public class EventRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eventRegistrationId;
	
	@ManyToOne
	@JoinColumn(name="employeeId",nullable=false)
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="eventId",nullable=false)
	private Event event;
	
//additional columns
//	private String status;
//	@Lob
//	private String feedback;

}