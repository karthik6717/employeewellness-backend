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

import com.gk.dto.ChallengeDto;
import com.gk.exception.EmployeeException;
import com.gk.service.ChallengeServiceImpl;


@RestController
@RequestMapping("/api/employeewellness")
@CrossOrigin("*")
public class ChallengeController {

	@Autowired
	private ChallengeServiceImpl challengeService;
	


@GetMapping("/ChallengesDetails/{challId}")	
public ResponseEntity<ChallengeDto>getChallengeById(@PathVariable Long challId)
{
	try
	{
		ChallengeDto challist = challengeService.getChallengeById(challId);
		return new ResponseEntity<ChallengeDto>(challist,HttpStatus.OK);
	}
	catch(EmployeeException e)
	{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
}
	
	

@GetMapping("/getallchallenges")
public ResponseEntity <List<ChallengeDto> > getAllChallenge()
{
	try
	{
		List<ChallengeDto> challist = challengeService.getAllChallenge();
		return new ResponseEntity<List<ChallengeDto>>(challist,HttpStatus.OK);
	}
	catch(EmployeeException e)
	{
	 throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
}
	
		
@PostMapping("/addChal")
public ResponseEntity<ChallengeDto> addChallenge(@RequestBody ChallengeDto chal)
{
	try
	{
		return new ResponseEntity<ChallengeDto>(challengeService.addChallenge(chal),HttpStatus.OK);
	}
	catch(EmployeeException e)
	{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
}
	
@DeleteMapping("/deleteChallenge/{challeId}")
public ResponseEntity<Long> removeChallenge(@PathVariable Long challeId)
{
	try
	{
		return new ResponseEntity<Long>(challengeService.removeChallenge(challeId),HttpStatus.OK);
		
	}
	catch(EmployeeException e)
	{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
}
	

@PutMapping("/updateChallenge")
public ResponseEntity<ChallengeDto> updateChallenge(@RequestBody ChallengeDto chal)
{
	try
	{
		return new ResponseEntity<ChallengeDto>(challengeService.updateChallenge(chal),HttpStatus.OK);
	}
	catch(EmployeeException e)
	{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
}

}
