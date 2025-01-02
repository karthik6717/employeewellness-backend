package com.gk.service;

import java.util.List;

import com.gk.dto.DoctorDto;

import com.gk.exception.EmployeeException;

public interface DoctorService {
	public DoctorDto getDoctorById(Long doctorId) throws EmployeeException;
    public List<DoctorDto> getAllDoctor() throws EmployeeException;
    public DoctorDto addDoctor(DoctorDto doctor) throws EmployeeException;
    public Long removeDoctor(Long doctorId) throws EmployeeException;
    public DoctorDto updateDoctor(DoctorDto doctor) throws EmployeeException;

}
