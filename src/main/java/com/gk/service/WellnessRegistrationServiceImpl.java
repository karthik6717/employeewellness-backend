package com.gk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.EmployeeRepository;
import com.gk.dao.WellnessProgramRepository;
import com.gk.dao.WellnessRegistrationRepository;
import com.gk.dto.WellnessRegistrationDto;
import com.gk.entity.Employee;
import com.gk.entity.WellnessProgram;
import com.gk.entity.WellnessRegistration;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class WellnessRegistrationServiceImpl implements WellnessRegistrationService {
	
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private WellnessProgramRepository wellnessProgramRepository;

	@Autowired
	private WellnessRegistrationRepository wellnessRegistrationRepository;
	
	@Autowired
	public WellnessRegistrationServiceImpl(WellnessRegistrationRepository wellnessRegistrationRepository,
			EmployeeRepository employeeRepo, WellnessProgramRepository wellnessProgramRepository) {
		this.wellnessRegistrationRepository = wellnessRegistrationRepository;
		this.employeeRepository = employeeRepo;
		this.wellnessProgramRepository = wellnessProgramRepository;
	}
	
	
	@Override
	public boolean registerForWellnessProgram(Long employeeId, Long wellnessId) {
		// Check if the challenge and employee combination already exists

		// ChallengeRegistration registration = new ChallengeRegistration();

		if (wellnessRegistrationRepository.existsByWellnessIdAndEmployeeId(wellnessId, employeeId)) {
			// Registration already exists
			return false;
		}

		Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
		Optional<WellnessProgram> wellnessOpt = wellnessProgramRepository.findById(wellnessId);

		// Check if both employee and challenge exist
		if (employeeOpt.isPresent() && wellnessOpt.isPresent()) {
			Employee employee = employeeOpt.get();
			WellnessProgram wellnessProgram = wellnessOpt.get();

			// Create a new ChallengeRegistration entry (if you have a ChallengeRegistration
			// entity)
			WellnessRegistration registration = new WellnessRegistration();
			registration.setEmployee(employee);
			registration.setWellnessProgram(wellnessProgram);
			
			System.out.println(registration);
			// Save the new registration
			wellnessRegistrationRepository.save(registration);
			return true;
		}
		return false;
	}

	
	@Override
	public List<WellnessRegistrationDto> getRegisteredWellnessByEmployeeId(Long employeeId) {
		// Fetch registered challenges for the given employee ID
		List<WellnessProgram> WellnessProgram = wellnessRegistrationRepository.findWellnessProgramByEmployeeId(employeeId);
		List<WellnessRegistrationDto> result = new ArrayList<>();

		// Convert entities to DTOs
		return WellnessProgram.stream()
				.map(wellnessProgram -> new WellnessRegistrationDto(wellnessProgram.getWellnessProgramId(),wellnessProgram.getProgramName(),
						wellnessProgram.getDescription(),wellnessProgram.getProgramType(),wellnessProgram.getStartDate(),
						wellnessProgram.getEndDate(),wellnessProgram.getMaxParticipants(),wellnessProgram.getVenue(),
						wellnessProgram.getLocationType())).collect(Collectors.toList());
	}


	



}
