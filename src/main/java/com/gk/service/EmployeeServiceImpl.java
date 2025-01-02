package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.EmployeeRepository;
import com.gk.dto.EmployeeDto;
import com.gk.entity.Employee;
import com.gk.exception.EmployeeException;
import com.gk.utils.EmployeeUtils;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Override
	public EmployeeDto getEmployeeById(Long empId) throws EmployeeException {
		
            Optional<Employee> emp= employeeRepository.findById(empId);
            if(emp.isPresent())
            {
                return EmployeeUtils.EntityToDto(emp.get());
            }
            else 
            {
                throw new EmployeeException("Invalid employee id");
            }
            
		
	}

	@Override
	public List<EmployeeDto> getAllEmployee() throws EmployeeException {
	
            List<Employee> empList= employeeRepository.findAll();
           if(empList.size() != 0) 
           {
               return EmployeeUtils.EntityToDtoList(empList);
           }
           else 
           {
               throw new EmployeeException("No Employees data");
           }
           
      
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto emp) throws EmployeeException {

			if(emp.getEmployeeId() != null && emp.getEmail()!=null && emp.getPassword()!=null && emp.getContactNumber() != null)
			{
			Employee emp1= employeeRepository.save(EmployeeUtils.dtoTOEntity(emp));
		
            return EmployeeUtils.EntityToDto(emp1);            
           }
			else
			{
            throw new EmployeeException("Please fill Required Details");
        }
	}

	@Override
	public Long removeEmployee(Long empId) throws EmployeeException {
		
			employeeRepository.deleteById(empId);
            Optional<Employee> note= employeeRepository.findById(empId);
            
            if(!note.isPresent())
            {
              return empId;    
            }
            else 
            {
                throw new EmployeeException("Unable to delete");
            }
        }
	

	@Override
	public EmployeeDto updateEmployee(EmployeeDto emp) throws EmployeeException {
		
			if(getEmployeeById(emp.getEmployeeId()) != null) 
			{
				Employee updatedNote= employeeRepository.save(EmployeeUtils.dtoTOEntity(emp));				
				return EmployeeUtils.EntityToDto(updatedNote);            
			}
		
			else
			{
				
				
            throw new EmployeeException("Unable Update Employee");
        }
	}

}
