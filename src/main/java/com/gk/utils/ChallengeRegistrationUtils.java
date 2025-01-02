package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.gk.dto.ChallengeRegistrationDto;

import com.gk.entity.ChallengeRegistration;


public class ChallengeRegistrationUtils {
	
public static ModelMapper mapper = new ModelMapper();
	
	static {
        // Configure the mapping explicitly to resolve ambiguity
        mapper.addMappings(new PropertyMap<ChallengeRegistration, ChallengeRegistrationDto>() {
            @Override
            protected void configure() {
                map().setChallengeRegistrationId(source.getChallenge().getChallengeId());
                map().setEmployeeId(source.getEmployee().getEmployeeId());
            }
        });
    }
	
	public static ChallengeRegistration dtoTOEntity(ChallengeRegistrationDto challenge)
	{
		return mapper.map(challenge,ChallengeRegistration.class);
	}
	
	public static ChallengeRegistrationDto EntityToDto(ChallengeRegistration challenge)
	{
		return mapper.map(challenge,ChallengeRegistrationDto.class);
	}
	public static List<ChallengeRegistrationDto> EntityToDtoList(List<ChallengeRegistration> challenge)
	{
		List<ChallengeRegistrationDto> resList = new ArrayList<>();
		challenge.forEach(e-> resList.add(EntityToDto(e)));
		return resList;
	}


}
