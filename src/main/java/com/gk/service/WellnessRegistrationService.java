package com.gk.service;

import java.util.List;

import com.gk.dto.WellnessRegistrationDto;
import com.gk.exception.EmployeeException;

public interface WellnessRegistrationService {
	boolean registerForWellnessProgram(Long employeeId, Long wellnessId);

	public List<WellnessRegistrationDto> getRegisteredWellnessByEmployeeId(Long employeeId);

}
