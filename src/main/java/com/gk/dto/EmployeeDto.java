package com.gk.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.gk.entity.BloodGroup;
import com.gk.entity.Gender;
import com.gk.entity.MaritialStatus;
import com.gk.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    
   
    private LocalDate dateOfBirth;
    
    private Gender gender;
    
    private BigDecimal weight;
    
  
    private BigDecimal height;
    
   
    private Role role;
    
   
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
