package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;


import com.gk.dto.WellnessRegistrationDto;

import com.gk.entity.WellnessRegistration;

public class WellnessRegistrationUtils {
	public static ModelMapper mapper = new ModelMapper();
	static {
        // Configure the mapping explicitly to resolve ambiguity
        mapper.addMappings(new PropertyMap<WellnessRegistration, WellnessRegistrationDto>() {
            @Override
            protected void configure() {
                map().setWellnessProgramId(source.getWellnessProgram().getWellnessProgramId());
                map().setEmployeeId(source.getEmployee().getEmployeeId());
            }
        });
    }
	public static WellnessRegistration dtoTOEntity(WellnessRegistrationDto ch)
	{
		return mapper.map(ch,WellnessRegistration.class);
	}

	public static WellnessRegistrationDto EntityToDto(WellnessRegistration ch)
	{
		return mapper.map(ch,WellnessRegistrationDto.class);
	}
	public static List< WellnessRegistrationDto> EntityToDtoList(List<WellnessRegistration> ch)
	{
		List<WellnessRegistrationDto> resList = new ArrayList<>();
		ch.forEach(e-> resList.add(EntityToDto(e)));
		return resList;
	}

}
