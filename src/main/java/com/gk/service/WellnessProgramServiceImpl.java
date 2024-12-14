package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.gk.dao.WellnessProgramRepository;

import com.gk.dto.WellnessProgramDto;

import com.gk.entity.WellnessProgram;
import com.gk.exception.EmployeeException;

import com.gk.utils.WellnessProgramUtils;

@Service
@Transactional
public class WellnessProgramServiceImpl implements WellnessProgramService {
	
	@Autowired
	private WellnessProgramRepository wellnessProgramRepository;

	@Override
	public WellnessProgramDto getWellnessProgramId(Long wpId) throws EmployeeException {
		
            Optional<WellnessProgram> wp= wellnessProgramRepository.findById(wpId);
            if(wp.isPresent())
            {
                return WellnessProgramUtils.EntityToDto(wp.get());
            }
            else
            {
                throw new EmployeeException("Invalid WellnessProgram id");
            }
            

	}

	@Override
	public List<WellnessProgramDto> getAllWellnessProgram() throws EmployeeException {
		
            List<WellnessProgram> wpList= wellnessProgramRepository.findAll();
           if(wpList.size() != 0)
           {
               return WellnessProgramUtils.EntityToDtoList(wpList);
           }
           else
           {
               throw new EmployeeException("No data in wellnessProgram");
           }
           
       
	}

	@Override
	public WellnessProgramDto addWellnessProgram(WellnessProgramDto wp) throws EmployeeException {
		
			WellnessProgram wp1= wellnessProgramRepository.save(WellnessProgramUtils.dtoTOEntity(wp));
		
            return WellnessProgramUtils.EntityToDto(wp1);            
        
	}

	@Override
	public Long removeWellnessProgram(Long wpId) throws EmployeeException {
		
			wellnessProgramRepository.deleteById(wpId);
            Optional<WellnessProgram> note= wellnessProgramRepository.findById(wpId);
            if(!note.isPresent())
            {
              return wpId;    
            }
            else 
            {
                throw new EmployeeException("Unable to delete WellnessProgram");
            }
        
	}

	@Override
	public WellnessProgramDto updateWellnessProgram(WellnessProgramDto wp) throws EmployeeException
	  {
		
			WellnessProgram updatedNote= wellnessProgramRepository.save(WellnessProgramUtils.dtoTOEntity(wp));
            return WellnessProgramUtils.EntityToDto(updatedNote);            
       }
	

}
