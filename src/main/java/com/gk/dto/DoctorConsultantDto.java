package com.gk.dto;

import java.time.LocalDateTime;

import com.gk.entity.Doctor;
import com.gk.entity.Employee;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class DoctorConsultantDto {
	
	
	private Long doctorConsultId;
	
	
	private Long employeeId;
	
	private Long doctorId;

}
