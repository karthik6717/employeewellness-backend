package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.ChallengeRepository;
import com.gk.dto.ChallengeDto;
import com.gk.entity.Challenge;
import com.gk.exception.EmployeeException;
import com.gk.utils.ChallengeUtils;

@Service
@Transactional
public class ChallengeServiceImpl implements ChallengeService{

	@Autowired
	private ChallengeRepository challengeRepository;
	
	@Override
	public ChallengeDto getChallengeById(Long chId) throws EmployeeException {
		
            Optional<Challenge> ch= challengeRepository.findById(chId);
            if(ch.isPresent()) {
                return ChallengeUtils.EntityToDto(ch.get());
            }else
            {
                throw new EmployeeException("Invalid Challenge id");
            }
            
       
	}

	@Override
	public List<ChallengeDto> getAllChallenge() throws EmployeeException {
		
            List<Challenge> chList= challengeRepository.findAll();
           if(chList.size() != 0) 
           {
               return ChallengeUtils.EntityToDtoList(chList);
           }
           else
           {
               throw new EmployeeException("No data");
           }
           
      
	}

	@Override
	public ChallengeDto addChallenge(ChallengeDto ch) throws EmployeeException
	{
		
		    
			Challenge ch1= challengeRepository.save(ChallengeUtils.dtoTOEntity(ch));
		
            return ChallengeUtils.EntityToDto(ch1);            
       
	}

	@Override
	public Long removeChallenge(Long chId) throws EmployeeException {
		
			challengeRepository.deleteById(chId);
            Optional<Challenge> note= challengeRepository.findById(chId);
            if(!note.isPresent())
            {
              return chId;    
            }
            else 
            {
                throw new EmployeeException("Unable to delete");
            }
       
	}

	@Override
	public ChallengeDto updateChallenge(ChallengeDto ch) throws EmployeeException {
		
			Challenge updatedNote= challengeRepository.save(ChallengeUtils.dtoTOEntity(ch));
            return ChallengeUtils.EntityToDto(updatedNote);            
        }
	}


