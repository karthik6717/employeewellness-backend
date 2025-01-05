package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gk.dto.DoctorDto;
import com.gk.exception.EmployeeException;
import com.gk.service.DoctorServiceImpl;

@RestController
@RequestMapping("/api/employeewellness")
@CrossOrigin("*")
public class DoctorController {
	@Autowired
	private DoctorServiceImpl doctorService;
	
	
	
	@GetMapping("/getDoctorById/{doctorId}")
	public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long doctorId)
	{
		try 
	     {
			return new ResponseEntity<DoctorDto>( doctorService.getDoctorById(doctorId),HttpStatus.OK);
		
		  }
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	
	
	
	
	
	
	@GetMapping("/getAllDoctors")
	public ResponseEntity< List<DoctorDto> > getAllEmployee()
	{
		try
		{
		   List<DoctorDto> doclist = doctorService.getAllDoctor();
		   return new ResponseEntity<>(doclist,HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	
	
	

	
	
	
	@PostMapping("/addDoctor")
	public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doc)
	{
		try
		{
			return new ResponseEntity<DoctorDto>(doctorService.addDoctor(doc),HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/remove/{doctorId}")
	public ResponseEntity<Long> removeDoctor(@PathVariable Long doctorId)
	{
		try
		{
			return new ResponseEntity<Long>(doctorService.removeDoctor(doctorId),HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PutMapping("/updateDoctor")
	public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctor)
	{
	try
		{
		return new ResponseEntity<DoctorDto>(doctorService.updateDoctor(doctor),HttpStatus.OK);
		}
		catch(EmployeeException e)
		{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	

}
