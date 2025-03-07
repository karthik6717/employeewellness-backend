package com.gk.entity;

import jakarta.persistence.Column;
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
//@ToString
@Table(name = "EmployeeWellness_batch2_ChallengeRegistration_karthikg")
public class ChallengeRegistration {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long challengeRegistrationId;
	
	@ManyToOne
	@JoinColumn(name="employeeId",nullable=false)
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="challengeId",nullable=false)
	private Challenge challenge;
	
//additional columns
	@Column(nullable=false)
	private String challengeStatus="Not Started";
	private Integer rewardPoints;
}
