package com.gk.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Version;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@ToString
@Table(name="EmployeeWellness_batch2_Doctor_table_karthikg")
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
	@Column
	private String hospitalAffilation;
	@Column
	private String location;
	@Column
	private LocalDateTime availableFrom;
	// "2020-12-31T15:53:16"
	@Column
	private LocalDateTime availableTill;
	@Column
	private String qualification;
	
	
//	@Version
//	@Column(name="version")
//	private Integer version;
	
//	//mapping
//	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
//	private List<DoctorConsultant> doctorList;

	
	
}
