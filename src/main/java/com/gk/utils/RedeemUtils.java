package com.gk.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.gk.dto.RedeemDto;
import com.gk.entity.Redeem;

public class RedeemUtils {
	public static ModelMapper mapper = new ModelMapper();
	public static Redeem dtoTOEntity(RedeemDto redeem)
	{
		return mapper.map(redeem,Redeem.class);
	}
	
	public static RedeemDto EntityToDto(Redeem redeem)
	{
		return mapper.map(redeem,RedeemDto.class);
	}
	public static List< RedeemDto> EntityToDtoList(List<Redeem> redeem)
	{
		List<RedeemDto> resList = new ArrayList<>();
		redeem.forEach(r-> resList.add(EntityToDto(r)));
		return resList;
	}

}
