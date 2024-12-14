package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.gk.dto.WellnessProgramDto;

import com.gk.entity.WellnessProgram;

public class WellnessProgramUtils {

	public static ModelMapper mapper = new ModelMapper();
	public static WellnessProgram dtoTOEntity(WellnessProgramDto wp)
	{
		return mapper.map(wp,WellnessProgram.class);
	}

	public static WellnessProgramDto EntityToDto(WellnessProgram wp)
	{
		return mapper.map(wp,WellnessProgramDto.class);
	}
	public static List< WellnessProgramDto> EntityToDtoList(List<WellnessProgram> wp)
	{
		List<WellnessProgramDto> resList = new ArrayList<>();
		wp.forEach(w-> resList.add(EntityToDto(w)));
		return resList;
	}

}
