package com.gk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.entity.Redeem;

@Repository
public interface RedeemRepository extends JpaRepository<Redeem, Long> {

}
