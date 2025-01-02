package com.gk.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gk.entity.Challenge;
import com.gk.entity.ChallengeRegistration;

@Repository
public interface ChallengeRegistrationRepository extends JpaRepository<ChallengeRegistration, Long> {

	@Query("SELECT CASE WHEN COUNT(cr) > 0 THEN TRUE ELSE FALSE END " + "FROM ChallengeRegistration cr "
			+ "WHERE cr.challenge.id = :challengeId AND cr.employee.id = :employeeId")
	boolean existsByChallengeIdAndEmployeeId(@Param("challengeId") Long challengeId,
			@Param("employeeId") Long employeeId);

	
	
	// @Query("select c from Challenge c where
	// 1c.employeeChallenge.employee.employeeId = ?1 ")
	@Query("SELECT c FROM Challenge c JOIN ChallengeRegistration cr ON c.challengeId = cr.challenge.challengeId WHERE cr.employee.employeeId = :employeeId")
	List<Challenge> findChallengesByEmployeeId(@Param("employeeId") Long employeeId);


//3
	@Query("SELECT cr FROM ChallengeRegistration cr WHERE cr.employee.employeeId = :employeeId")
	List<ChallengeRegistration> findChallengesRegistrationByEmployeeId(@Param("employeeId") Long employeeId);

//	to retrieve status by employeeid and challenge id
	//@Query("SELECT cr FROM ChallengeRegistration cr WHERE cr.employee.employeeId = :employeeId AND cr.challengeRegistrationId = :challengeId")
	//ChallengeRegistration findChallengeStatusByEmployeeId(Long employeeId, Long challengeId);

	//2
	@Query("SELECT cr FROM ChallengeRegistration cr "
			+ "WHERE cr.employee.employeeId = :employeeId AND cr.challenge.challengeId = :challengeId")
	Optional<ChallengeRegistration> findByEmployeeAndChallengeId(@Param("employeeId") Long employeeId,
			@Param("challengeId") Long ChallengeId);

}
