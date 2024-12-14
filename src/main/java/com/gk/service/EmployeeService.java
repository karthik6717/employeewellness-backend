package com.gk.service;

import java.util.List;

import com.gk.dto.EmployeeDto;
import com.gk.entity.Employee;
import com.gk.exception.EmployeeException;



public interface EmployeeService {
	
	
	public EmployeeDto getEmployeeById(Long empId) throws EmployeeException;
    public List<EmployeeDto> getAllEmployee() throws EmployeeException;
    public EmployeeDto addEmployee(EmployeeDto emp) throws EmployeeException;
    public Long removeEmployee(Long empId) throws EmployeeException;
    public EmployeeDto updateEmployee(EmployeeDto emp) throws EmployeeException;

}
