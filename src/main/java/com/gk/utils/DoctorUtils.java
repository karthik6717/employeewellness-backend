package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.gk.dto.DoctorDto;

import com.gk.entity.Doctor;


public class DoctorUtils {
	public static ModelMapper mapper = new ModelMapper();
	public static Doctor dtoTOEntity(DoctorDto doctor)
	{
		return mapper.map(doctor,Doctor.class);
	}
	
	public static DoctorDto EntityToDto(Doctor doctor)
	{
		return mapper.map(doctor,DoctorDto.class);
	}
	public static List< DoctorDto> EntityToDtoList(List<Doctor> doctor)
	{
		List<DoctorDto> resList = new ArrayList<>();
		doctor.forEach(d-> resList.add(EntityToDto(d)));
		return resList;
	}

}
