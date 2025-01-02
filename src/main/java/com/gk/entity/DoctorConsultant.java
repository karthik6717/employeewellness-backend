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
@Table(name = "EmployeeWellness_batch2_DoctorConsultant_karthikg")
public class DoctorConsultant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long doctorConsultId;
	
	@ManyToOne
	@JoinColumn(name="employeeId",nullable=false)
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="doctorId",nullable=false)
	private Doctor doctor;
	

}
