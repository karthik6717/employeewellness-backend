package com.gk.service;

import java.util.List;

import com.gk.dto.ChallengeDto;
import com.gk.exception.EmployeeException;

public interface ChallengeService {
	public ChallengeDto getChallengeById(Long chId) throws EmployeeException;
    public List<ChallengeDto> getAllChallenge() throws EmployeeException;
    public ChallengeDto addChallenge(ChallengeDto ch) throws EmployeeException;
    public Long removeChallenge(Long chId) throws EmployeeException;
    public ChallengeDto updateChallenge(ChallengeDto ch) throws EmployeeException;

}
