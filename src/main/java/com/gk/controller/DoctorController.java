package com.gk.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gk.dto.DoctorDto;
import com.gk.exception.EmployeeException;
import com.gk.service.DoctorServiceImpl;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorServiceImpl doctorService;
	
	
	
//	@GetMapping("/getDoctorById")
//	public String geteventId() {
//		return "getDoctorById";
//	}
//	
//	@GetMapping("/doctorDetails")
//	public ModelAndView getDoctorById(@RequestParam Long eventId)  {
//		// ("templateanmae" ,"thymvarname",passingparameter)
//
//		try {
//			EventDto eventlist = eventService.getEventById(eventId);
//			if (eventlist != null)
//				return new ModelAndView("getEventById", "eventId", eventlist);
//			
//		}
//		catch (Exception e) {
//			return new ModelAndView("message", "message", e.getMessage());
//		}
//		return null;
//		
//	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/getallDoctors")
	public ModelAndView getAllEvents(@RequestParam String empId) throws EmployeeException {
		List<DoctorDto> docList = doctorService.getAllDoctor();
		ModelAndView mv = new ModelAndView("getallDoctors");
		mv.addObject("docList", docList);
		mv.addObject("empId", empId);
		return mv;
		

	}
	
	
	

	
	@GetMapping("/addDoctor")
	public String add() {
		return "addDoctor";
	}
	
	
	@PostMapping("/addDoctor")
  public ModelAndView addDoctor(
		  @RequestParam String doctorName,
          @RequestParam(required = false) String specialization,
          @RequestParam(required = false) String contactNumber, 
          @RequestParam(required = false) String email, @RequestParam(required = false) String hospitalAffilation,
          @RequestParam(required = false) String location, @RequestParam(required = false) LocalDateTime availableFrom,
          @RequestParam(required = false) LocalDateTime availableTill,@RequestParam(required = false) String qualification) throws EmployeeException {
      
          //ModelAndView modelAndView = new ModelAndView("redirect:/doctor/getalldoctors"); // Redirect to doctor list view
      
          DoctorDto doc = new DoctorDto(doctorName,specialization,contactNumber,email,hospitalAffilation,location,availableFrom,availableTill,qualification);
          if(doctorService.addDoctor(doc) !=null)
        	 
           return new ModelAndView("message", "message", "Doctor Added");
          return new ModelAndView("message", "message", "Doctor Not Added");
	
     
  }
	
//	@GetMapping("/remove/{doctorId}")
//	public ResponseEntity<Long> removeDoctor(@PathVariable Long doctorId)
//	{
//		try
//		{
//			return new ResponseEntity<Long>(doctorService.removeDoctor(doctorId),HttpStatus.OK);
//		}
//		catch(EmployeeException e)
//		{
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
//	
//	@PostMapping("/update")
//	public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctor)
//	{
//		try
//		{
//			return new ResponseEntity<DoctorDto>(doctorService.updateDoctor(doctor),HttpStatus.OK);
//		}
//		catch(EmployeeException e)
//		{
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	
	

}
