package com.gk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.entity.DoctorConsultant;

@Repository
public interface DoctorConsultantRepository extends JpaRepository<DoctorConsultant,Long>{

}
