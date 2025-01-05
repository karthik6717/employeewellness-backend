package com.gk.dto;

import java.time.LocalDateTime;




import jakarta.persistence.Column;


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
public class DoctorDto {
	
	
	
		
		
		private Long doctorId;
		
		
	
		private String doctorName;
		
		
		private String specialization;
		
	
		private String contactNumber;
		
	
		private String email;
		private String hospitalAffilation;
		private String location;
		private LocalDateTime availableFrom;
		private LocalDateTime availableTill;
		private String qualification;
		
	
		
	}

