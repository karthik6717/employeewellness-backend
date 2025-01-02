package com.gk.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="EmployeeWellness_batch2_Doctor_karthikg")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	// "2020-12-31T15:53:16"
	private LocalDateTime availableTill;
	private String qualification;
	
	//mapping
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	private List<DoctorConsultant> doctorList;

	
	
}
