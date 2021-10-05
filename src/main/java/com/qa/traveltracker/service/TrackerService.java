package com.qa.traveltracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.traveltracker.domain.TravelTracker;
import com.qa.traveltracker.repo.TravelTrackerRepo;

@Service
public class TrackerService {

	private TravelTrackerRepo repo;

	@Autowired
	public TrackerService(TravelTrackerRepo repo) {
		this.repo = repo;
	}

//create 
	public TravelTracker create(TravelTracker a) {
		return this.repo.saveAndFlush(a);
	}

//ReadAll

	public List<TravelTracker> readAll() {
		return this.repo.findAll();
	}

//Read id

	public TravelTracker read(long id) {
		return this.repo.findById(id).get();
	}

//update 
	public TravelTracker update(TravelTracker a, long id) {
		TravelTracker exists = this.repo.findById(id).orElseThrow();
		exists.setTravelMethod(a.getTravelMethod());
		exists.setStartTime(a.getStartTime());
		exists.setFinishTime(a.getFinishTime());
		exists.setStartDestination(a.getStartDestination());
		exists.setFinishDestination(a.getFinishDestination());
		return this.repo.saveAndFlush(exists);

	}

//delete
	public boolean delete(long id) throws Exception {
		if (!this.repo.existsById(id)) {
			throw new Exception();
		}
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

////Findbyname
//	public List<Animals> findByName(String name) {
//		return this.repo.findByname(name);
}
//}