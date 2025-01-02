package com.gk.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.ChallengeRegistrationRepository;
import com.gk.dao.ChallengeRepository;
import com.gk.dao.EmployeeRepository;
import com.gk.dto.ChallengeRegistrationDto;

import com.gk.entity.Challenge;
import com.gk.entity.ChallengeRegistration;
import com.gk.entity.Employee;

@Service
@Transactional
public class ChallengeRegistrationServiceImpl implements ChallengeRegistrationService {

	@Autowired
	private ChallengeRepository challengeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ChallengeRegistrationRepository challRegRepo;

	@Autowired
	public ChallengeRegistrationServiceImpl(ChallengeRegistrationRepository challengeRegRepo,
			EmployeeRepository employeeRepo, ChallengeRepository challengeRepo) {
		this.challRegRepo = challengeRegRepo;
		this.employeeRepository = employeeRepo;
		this.challengeRepository = challengeRepo;
	}

	@Override
	public boolean registerForChallenge(Long employeeId, Long challengeId) {
		// Check if the challenge and employee combination already exists

		// ChallengeRegistration registration = new ChallengeRegistration();

		if (challRegRepo.existsByChallengeIdAndEmployeeId(challengeId, employeeId)) {
			// Registration already exists
			return false;
		}

		Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
		Optional<Challenge> challengeOpt = challengeRepository.findById(challengeId);

		// Check if both employee and challenge exist
		if (employeeOpt.isPresent() && challengeOpt.isPresent()) {
			Employee employee = employeeOpt.get();
			Challenge challenge = challengeOpt.get();

			// Create a new ChallengeRegistration entry (if you have a ChallengeRegistration
			// entity)
			ChallengeRegistration registration = new ChallengeRegistration();
			registration.setEmployee(employee);
			registration.setChallenge(challenge);

			// Save the new registration
			challRegRepo.save(registration);
			return true;
		}
		return false;
	}



	// original method

	@Override
	public List<ChallengeRegistrationDto> getRegisteredChallengesByEmployeeId(Long employeeId) {
		// Fetch registered challenges for the given employee ID
		List<Challenge> challenges = challRegRepo.findChallengesByEmployeeId(employeeId);
		List<ChallengeRegistrationDto> result = new ArrayList<>();

		// Convert entities to DTOs
		return challenges.stream()
				.map(challenge -> new ChallengeRegistrationDto(challenge.getChallengeId(), challenge.getChallengeName(),
						challenge.getStartDate(), challenge.getEndDate(), challenge.getRewardPoints(),challenge.getDescription(), 
						challRegRepo.findByEmployeeAndChallengeId(employeeId, challenge.getChallengeId()).get().getChallengeStatus())).collect(Collectors.toList());
	}



	// previous method

	@Override
	public void completeChallenges(Long employeeId, Long challengeId, String challengeStatus) {
		// Fetch the employee
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

		// Fetch the challenge registration
		ChallengeRegistration registration = challRegRepo.findByEmployeeAndChallengeId(employeeId, challengeId)
				.orElseThrow(() -> new RuntimeException("Challenge not registered: " + challengeId));

		// Validate status and end date
		if ("completed".equalsIgnoreCase(challengeStatus)
				&& registration.getChallenge().getEndDate().isAfter(LocalDate.now())) {

			// Update status in ChallengeRegistration table
			registration.setChallengeStatus("completed");
			challRegRepo.save(registration);

			int existingPoints = employee.getTotalRewardPoints() != null ? employee.getTotalRewardPoints() : 0;
			int challengePoints = registration.getChallenge().getRewardPoints();
			employee.setTotalRewardPoints(existingPoints + challengePoints);


		} else {
			throw new RuntimeException(
					"Challenge not completed before the end date or status is invalid for challenge ID: "
							+ challengeId);
		}

		// Save updated employee
		employeeRepository.save(employee);

	}
//       

	// for get status
	@Override
	public List<ChallengeRegistrationDto> getRegisteredChallengesStatus(Long employeeId) {
		// TODO Auto-generated method stub
		List<ChallengeRegistration> challenges = challRegRepo.findChallengesRegistrationByEmployeeId(employeeId);

		// Convert entities to DTOs
		return challenges.stream()
				.map(challenge -> new ChallengeRegistrationDto(challenge.getChallenge().getChallengeId(),
						challenge.getChallenge().getChallengeName(), challenge.getChallenge().getStartDate(),
						challenge.getChallenge().getEndDate(), challenge.getChallenge().getRewardPoints(),
						challenge.getChallenge().getDescription(), challenge.getChallengeStatus()))
				.collect(Collectors.toList());

	}
	
}
