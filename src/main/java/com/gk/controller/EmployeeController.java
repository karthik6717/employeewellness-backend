package com.gk.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gk.dto.EmployeeDto;
import com.gk.exception.EmployeeException;
import com.gk.service.EmployeeServiceImpl;


@RestController
@RequestMapping("/api/employeewellness")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long empId)
	{
		try 
	     {
			return new ResponseEntity<EmployeeDto>( employeeService.getEmployeeById(empId),HttpStatus.OK);
		
		  }
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	
	@GetMapping("/getallemps")
	public ResponseEntity< List<EmployeeDto> > getAllEmployee()
	{
		try
		{
		   List<EmployeeDto> emplist = employeeService.getAllEmployee();
		   return new ResponseEntity<>(emplist,HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto emp)
	{
		try
		{
			return new ResponseEntity<EmployeeDto>(employeeService.addEmployee(emp),HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/remove/{empId}")
	public ResponseEntity<Long> removeEmployee(@PathVariable Long empId)
	{
		try
		{
			return new ResponseEntity<Long>(employeeService.removeEmployee(empId),HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto emp)
	{
		try
		{
			return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(emp),HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
