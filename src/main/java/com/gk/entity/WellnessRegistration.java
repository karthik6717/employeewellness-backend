package com.gk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "EmployeeWellness_batch2_wellnessRegistration_karthikg")
public class WellnessRegistration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long wellnessRegistrationId;
	
	@ManyToOne
	@JoinColumn(name="employeeId",nullable=false)
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="wellnessProgramId",nullable=false)
	private WellnessProgram wellnessProgram;
	
	//additional columns
	//private String status;
	//private Integer certificateId;
	
	
}
