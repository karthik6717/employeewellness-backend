package com.gk.dto;

import java.time.LocalDate;

import com.gk.entity.Challenge;
import com.gk.entity.Employee;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChallengeRegistrationDto {
	
	private Long challengeId;
    private String challengeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer rewardPoints;
    private String description;
    private Long challengeRegistrationId;
    private Long employeeId;
    private String challengeStatus;

    // Constructors, Getters, and Setters
    public ChallengeRegistrationDto(Long challengeId, String challengeName, LocalDate startDate, 
                                     LocalDate endDate, int rewardPoints, String description  ) {
        this.challengeId = challengeId;
        this.challengeName = challengeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rewardPoints = rewardPoints;
        this.description = description;
       // this.challengeStatus=challengeStatus;
    }
		
    public ChallengeRegistrationDto(Long challengeId, String challengeName, LocalDate startDate, 
            LocalDate endDate, int rewardPoints, String description ,String challengeStatus ) {
        this.challengeId = challengeId;
        this.challengeName = challengeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rewardPoints = rewardPoints;
        this.description = description;
       this.challengeStatus=challengeStatus;
}
    
    
//    //get status
//    public ChallengeRegistrationDto( String challengeStatus ) {
//      
//       this.challengeStatus=challengeStatus;
//}
		
		
		
		
		
		
		
	//  additional columns
		
		
}
