package com.gk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.entity.Challenge;
@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long>
{

}
