package com.gk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gk.entity.WellnessProgram;

@Repository
public interface WellnessProgramRepository extends JpaRepository<WellnessProgram, Long> {
  
	
	
}
