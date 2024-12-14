package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.gk.dto.ChallengeDto;
import com.gk.entity.Challenge;


public class ChallengeUtils {

	public static ModelMapper mapper = new ModelMapper();
	public static Challenge dtoTOEntity(ChallengeDto ch)
	{
		return mapper.map(ch,Challenge.class);
	}
	
	public static ChallengeDto EntityToDto(Challenge ch)
	{
		return mapper.map(ch,ChallengeDto.class);
	}
	public static List< ChallengeDto> EntityToDtoList(List<Challenge> ch)
	{
		List<ChallengeDto> resList = new ArrayList<>();
		ch.forEach(c-> resList.add(EntityToDto(c)));
		return resList;
	}
	
}
