package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk.dao.DoctorRepository;
import com.gk.dto.DoctorDto;
import com.gk.entity.Doctor;

import com.gk.exception.EmployeeException;
import com.gk.utils.DoctorUtils;


@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepo;

	@Override
	public DoctorDto getDoctorById(Long doctorId) throws EmployeeException {
		// TODO Auto-generated method stub
		
	
            Optional<Doctor> doctor= doctorRepo.findById(doctorId);
            if(doctor.isPresent()) 
            {
                return DoctorUtils.EntityToDto(doctor.get());
            }
            else
            {
                throw new EmployeeException("Invalid doctor id");
            }
            
        
	
	}

	@Override
	public List<DoctorDto> getAllDoctor() throws EmployeeException {
		// TODO Auto-generated method stub
		
            List<Doctor> doctorList= doctorRepo.findAll();
           if(doctorList.size() != 0)
           {
               return DoctorUtils.EntityToDtoList(doctorList);
           }else
           {
               throw new EmployeeException("No data");
           }
           
       
	}

	@Override
	public DoctorDto addDoctor(DoctorDto doctor) throws EmployeeException {
		
		
		{
			Doctor doc1= doctorRepo.save(DoctorUtils.dtoTOEntity(doctor));
			return DoctorUtils.EntityToDto(doc1);            
		}
	

            
	}

	@Override
	public Long removeDoctor(Long doctorId) throws EmployeeException {
		// TODO Auto-generated method stub
		
			doctorRepo.deleteById(doctorId);
            Optional<Doctor> doctor= doctorRepo.findById(doctorId);
            
            if(!doctor.isPresent()) {
              return doctorId;    
            }
            else
            {
                throw new EmployeeException("Unable to delete");
            
            }
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctor) throws EmployeeException {
		// TODO Auto-generated method stub
          
			Doctor updatedDoctor= doctorRepo.save(DoctorUtils.dtoTOEntity(doctor));
            return DoctorUtils.EntityToDto(updatedDoctor);            
        }
	}


