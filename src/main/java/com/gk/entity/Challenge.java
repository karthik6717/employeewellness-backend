package com.gk.entity;

import java.time.LocalDate;
import java.util.List;

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
@Table(name="EmployeeWellness_batch2_Challenge_karthikg")
public class Challenge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long challengeId;
	
	@Column()
	private String challengeName;
	
	@Column()
	private LocalDate startDate;
	
	@Column()
	private LocalDate endDate;
	
	@Column()
	private Integer rewardPoints;
    
	@Column()
	private String description;

	//Mappings
	
	@OneToMany(mappedBy="challenge",cascade=CascadeType.ALL)
	private List<ChallengeRegistration> employeeChallenge;
	
	//@Many
	

}
