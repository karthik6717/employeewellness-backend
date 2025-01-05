package com.gk.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "EmployeeWellness_batch2_Employee_karthikg")
public class Employee {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long employeeId;

	@Column(length = 100)
	private String firstName;

	@Column(length = 100)
	private String lastName;

	@Column(unique = true, length = 255)
	private String email;

	@Column()
	private String password;

	@Column(length = 100)
	private String contactNumber;

	@Column()
	private String department;

	@Column()
	private LocalDate dateOfBirth;

	@Column()
	private Gender gender;

	@Column(precision = 5, scale = 2)
	private BigDecimal weight;

	@Column(precision = 5, scale = 2)
	private BigDecimal height;

	@Column()
	private Role role;

	@Column()
	private LocalDate dateOfJoining;

	@Column()
	private String hobbies;

	@Column()
	private String address;

	@Column()
	private String sportsInterest;

	@Column(length = 100)
	private String medicalHistory;

	@Column()
	private String emergencyContact;

	@Column(length = 100)
	private BloodGroup bloodGroup;// enum?
//    
	@Column(length = 100)
	private MaritialStatus maritalStatus;// enum?
//    
	@Column()
	private String nationality;
//    
	@Column()
	private Integer totalRewardPoints=0;

	// mappings

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EventRegistration> eventRegistration;
//    
//    
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<WellnessRegistration> wellnessRegistration;
//    
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<ChallengeRegistration> challengeRegistrations;
//    
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Redeem> redeemList;

//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	private List<DoctorConsultant> DoctorList;

}
