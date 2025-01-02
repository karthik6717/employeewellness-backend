package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.gk.dto.EmployeeDto;
import com.gk.entity.Employee;

public class EmployeeUtils {

	public static ModelMapper mapper = new ModelMapper();
	public static Employee dtoTOEntity(EmployeeDto emp)
	{
		return mapper.map(emp,Employee.class);
	}
	
	public static EmployeeDto EntityToDto(Employee emp)
	{
		return mapper.map(emp,EmployeeDto.class);
	}
	public static List< EmployeeDto> EntityToDtoList(List<Employee> emp)
	{
		List<EmployeeDto> resList = new ArrayList<>();
		emp.forEach(e-> resList.add(EntityToDto(e)));
		return resList;
	}
}
