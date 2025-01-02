package com.gk.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.gk.entity.WellnessProgram;
import com.gk.entity.WellnessRegistration;

@Repository
public interface WellnessRegistrationRepository extends JpaRepository<WellnessRegistration, Long>{
	@Query("SELECT CASE WHEN COUNT(wr) > 0 THEN TRUE ELSE FALSE END " + "FROM WellnessRegistration wr "
			+ "WHERE wr.wellnessProgram.id = :wellnessProgramId AND wr.employee.id = :employeeId")
	boolean existsByWellnessIdAndEmployeeId(@Param("wellnessProgramId") Long wellnessProgramId,
			@Param("employeeId") Long employeeId);
	
	@Query("SELECT w FROM WellnessProgram w JOIN WellnessRegistration wr ON w.wellnessProgramId = wr.wellnessProgram.wellnessProgramId WHERE wr.employee.employeeId = :employeeId")
	List<WellnessProgram> findWellnessProgramByEmployeeId(@Param("employeeId") Long employeeId);
	

	@Query("SELECT wr FROM WellnessRegistration wr WHERE wr.employee.employeeId = :employeeId")
	List<WellnessRegistration> findWellnessProgramsRegistrationByEmployeeId(@Param("employeeId") Long employeeId);
	
	@Query("SELECT wr FROM WellnessRegistration wr "
			+ "WHERE wr.employee.employeeId = :employeeId AND wr.wellnessProgram.wellnessProgramId = :wellnessProgramId")
	Optional<WellnessRegistration> findByEmployeeAndwellnessProgramId(@Param("employeeId") Long employeeId,
			@Param("wellnessProgramId") Long wellnessProgramId);
	
}
