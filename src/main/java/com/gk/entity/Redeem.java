package com.gk.entity;

import java.time.LocalDate;

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
@ToString
@Table(name = "EmployeeWellness_batch2_Redeem_karthikg")
public class Redeem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long redeemId;
	
	private String description;
	private Integer pointsRedeemed;
	private LocalDate RedeemDate;
	private Integer balancePoints;//calc to be done from employee table
	private String remedeemedType;
	

	//mappings
	
	@ManyToOne
	@JoinColumn(name="employeeId",nullable=false)
	private Employee employee;
}

