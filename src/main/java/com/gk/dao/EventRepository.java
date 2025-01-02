package com.gk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
