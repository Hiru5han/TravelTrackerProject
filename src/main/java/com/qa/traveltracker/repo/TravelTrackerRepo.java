package com.qa.traveltracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.traveltracker.domain.TravelTracker;

@Repository
public interface TravelTrackerRepo extends JpaRepository<TravelTracker, Long> {

}