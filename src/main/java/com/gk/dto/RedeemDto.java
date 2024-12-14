package com.gk.dto;

import java.time.LocalDate;

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

public class RedeemDto {
	
	
	private Long redeemId;
	
	private String description;
	private Integer pointsRedeemed;
	private LocalDate RedeemDate;
	private Integer balancePoints;//calc to be done from employee table
	private String remedeemedType;
	

	
	
}