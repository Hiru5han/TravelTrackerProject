package com.qa.traveltracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.traveltracker.domain.TravelTracker;

@Repository
public interface TravelTrackerRepo extends JpaRepository<TravelTracker, Long> {
	@Query(value = "SELECT * FROM TravelTracker Where first_name = ?1", nativeQuery = true)
	List<TravelTracker>findByid(Long id);

}