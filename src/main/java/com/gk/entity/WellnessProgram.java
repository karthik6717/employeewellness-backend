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
import jakarta.persistence.Lob;
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
@Table(name = "EmployeeWellness_batch2_WellnessProgram_karthikg")
public class WellnessProgram {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	//mapping
	
	@OneToMany(mappedBy="wellnessProgram",cascade=CascadeType.ALL)
	private List<WellnessRegistration> employeeWellness;
	
	

}