package com.gk.dto;



import java.time.LocalDate;

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
public class ChallengeDto {
	public ChallengeDto(String challengeName, LocalDate startDate, LocalDate endDate, Integer rewardPoints,
			String description) {
		super();
		this.challengeName = challengeName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rewardPoints = rewardPoints;
		this.description = description;
	}
	private Long challengeId;

	private String challengeName;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer rewardPoints;
	@Lob
	private String description;
	

	

}
