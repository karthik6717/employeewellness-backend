package com.gk.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gk.entity.BloodGroup;
import com.gk.entity.Gender;
import com.gk.entity.MaritialStatus;
import com.gk.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class EmployeeDto {
	
	
	
	
	
	
	
    private Long employeeId;
    
    
	
   
    private String firstName;
    
    
    private String lastName;
   
    private String email;
    
   
    private String password;
    
    
    private String contactNumber;
   
    private String department;
    
  //  @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    private Gender gender;
    
    private BigDecimal weight;
    
  
    private BigDecimal height;
    
   
    private Role role;
    
  //  @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoining;
    
   
    private String hobbies;
    
    
    private String address;
//    
   
    private String sportsInterest;
//    
   
    private String medicalHistory;
    
   
    private String emergencyContact;
    
   
    private BloodGroup bloodGroup;//enum?
//    
    
    private MaritialStatus maritalStatus;//enum?
//    
    
    private String nationality;
//    
    
     private Integer totalRewardPoints;
    
    
   
   
    
    
   
    
	
	


}
