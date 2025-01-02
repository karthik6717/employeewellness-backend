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
		
		
		@Column()
		private String doctorName;
		
		@Column()
		private String specialization;
		
		@Column()
		private String contactNumber;
		
		@Column()
		private String email;
		private String hospitalAffilation;
		private String location;
		private LocalDateTime availableFrom;
		private LocalDateTime availableTill;
		private String qualification;
		
		public DoctorDto(String doctorName, String specialization, String contactNumber, String email,
				String hospitalAffilation, String location, LocalDateTime availableFrom, LocalDateTime availableTill,
				String qualification) {
			super();
			this.doctorName = doctorName;
			this.specialization = specialization;
			this.contactNumber = contactNumber;
			this.email = email;
			this.hospitalAffilation = hospitalAffilation;
			this.location = location;
			this.availableFrom = availableFrom;
			this.availableTill = availableTill;
			this.qualification = qualification;
		}
		
	}

