package com.gk.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gk.entity.Event;
import com.gk.entity.EventRegistration;

@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {

	 @Query("SELECT CASE WHEN COUNT(er) > 0 THEN TRUE ELSE FALSE END " +
	           "FROM EventRegistration er " +
	           "WHERE er.event.id = :eventId AND er.employee.id = :employeeId")
	    boolean existsByEventIdAndEmployeeId(@Param("eventId") Long eventId,
	                                             @Param("employeeId") Long employeeId);
	
	 
	 
	// @Query("select c from Challenge c where
		// 1c.employeeChallenge.employee.employeeId = ?1 ")
		@Query("SELECT e FROM Event e JOIN EventRegistration er ON e.eventId = er.event.eventId WHERE er.employee.employeeId = :employeeId")
		List<Event> findEventsByEmployeeId(@Param("employeeId") Long employeeId);


	//3
		@Query("SELECT er FROM EventRegistration er WHERE er.employee.employeeId = :employeeId")
		List<EventRegistration> findEventsRegistrationByEmployeeId(@Param("employeeId") Long employeeId);

//		to retrieve status by employeeid and challenge id
		//@Query("SELECT cr FROM ChallengeRegistration cr WHERE cr.employee.employeeId = :employeeId AND cr.challengeRegistrationId = :challengeId")
		//ChallengeRegistration findChallengeStatusByEmployeeId(Long employeeId, Long challengeId);

		//2
		@Query("SELECT er FROM EventRegistration er "
				+ "WHERE er.employee.employeeId = :employeeId AND er.event.eventId = :eventId")
		Optional<EventRegistration> findByEmployeeAndEventId(@Param("employeeId") Long employeeId,
				@Param("eventId") Long EventId); 
	 
	 
	 
	 
	 
	 
	 
}
