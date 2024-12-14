package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;


import com.gk.dto.DoctorConsultantDto;

import com.gk.entity.DoctorConsultant;

public class DoctorConsultantUtil {
	
public static ModelMapper mapper = new ModelMapper();
	
	static {
        // Configure the mapping explicitly to resolve ambiguity
        mapper.addMappings(new PropertyMap<DoctorConsultant, DoctorConsultantDto>() {
            @Override
            protected void configure() {
                map().setDoctorConsultId(source.getDoctor().getDoctorId());
                map().setEmployeeId(source.getEmployee().getEmployeeId());
            }
        });
    }
	
	public static DoctorConsultant dtoTOEntity(DoctorConsultantDto doctor)
	{
		return mapper.map(doctor,DoctorConsultant.class);
	}
	
	public static DoctorConsultantDto EntityToDto(DoctorConsultant doctor)
	{
		return mapper.map(doctor,DoctorConsultantDto.class);
	}
	public static List<DoctorConsultantDto> EntityToDtoList(List<DoctorConsultant> doctor)
	{
		List<DoctorConsultantDto> resList = new ArrayList<>();
		doctor.forEach(e-> resList.add(EntityToDto(e)));
		return resList;
	}

}
