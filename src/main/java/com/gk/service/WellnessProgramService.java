package com.gk.service;

import java.util.List;

import com.gk.dto.WellnessProgramDto;
import com.gk.exception.EmployeeException;

public interface WellnessProgramService {
	public WellnessProgramDto getWellnessProgramId(Long wpId) throws EmployeeException;
    public List<WellnessProgramDto> getAllWellnessProgram() throws EmployeeException;
    public WellnessProgramDto addWellnessProgram(WellnessProgramDto wp) throws EmployeeException;
    public Long removeWellnessProgram(Long wpId) throws EmployeeException;
    public WellnessProgramDto updateWellnessProgram(WellnessProgramDto wp) throws EmployeeException;

}
