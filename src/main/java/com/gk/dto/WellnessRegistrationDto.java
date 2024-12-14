package com.gk.dto;



import java.time.LocalDate;

import com.gk.entity.ProgramType;

import jakarta.persistence.Lob;
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
public class WellnessRegistrationDto {

	private Long wellnessRegistrationId;
	private Long employeeId;
	private Long wellnessProgramId;
	private String programName;
	@Lob
	private String Description;
	private ProgramType programType;//ENUM
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer maxParticipants;
	private String venue;
	private String locationType;
	
	public WellnessRegistrationDto(Long wellnessProgramId, String programName, String description,
			ProgramType programType, LocalDate startDate, LocalDate endDate, Integer maxParticipants, String venue,
			String locationType) {
		super();
		this.wellnessProgramId = wellnessProgramId;
		this.programName = programName;
		this.Description = description;
		this.programType = programType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.maxParticipants = maxParticipants;
		this.venue = venue;
		this.locationType = locationType;
	}
	
	
	
}
