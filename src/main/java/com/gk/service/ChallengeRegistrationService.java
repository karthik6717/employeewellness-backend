
package com.gk.service;

import java.util.List;


import com.gk.dto.ChallengeRegistrationDto;




public interface ChallengeRegistrationService {

    // Method to register an employee for a challenge
    boolean registerForChallenge(Long employeeId, Long challengeId);
    
    
    public List<ChallengeRegistrationDto> getRegisteredChallengesByEmployeeId(Long employeeId);
    
   // public Map<Challenge, ChallengeRegistration> getRegisteredChallengesByEmployeeId(Long employeeId);
    
    
    public void completeChallenges(Long employeeId,Long challengeId,String challengeStatus) throws Exception;
    
    //for get status
    public List<ChallengeRegistrationDto> getRegisteredChallengesStatus(Long employeeId);
    
  
}
