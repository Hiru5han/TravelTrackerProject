package com.qa.traveltracker.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.traveltracker.domain.TravelTracker;
import com.qa.traveltracker.service.TrackerService;

@RestController
@RequestMapping("/api")
public class TravelTrackerController {
	
	private TrackerService service;
	
	public TravelTrackerController(TrackerService service) {
		super();
		this.service = service;
	}
	
	// CREATE
	@PostMapping("/create")
	public ResponseEntity<TravelTracker> createMusic(@RequestBody TravelTracker tracker) {
		return new ResponseEntity<TravelTracker>(this.service.create(tracker), HttpStatus.CREATED);
	}
	
	// READ ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<TravelTracker>> getAll() {
		return new ResponseEntity<List<TravelTracker>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// READ ONE
	@GetMapping("/getOne/{id}")
	public ResponseEntity<TravelTracker> getOne(@PathVariable long tripname) {
		return new ResponseEntity<TravelTracker>(this.service.getOne(tripname), HttpStatus.OK);
	}
	
	// DELETE
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long tripname) {
		return (this.service.delete(tripname)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<TravelTracker> update(@RequestBody TravelTracker newTravelTracker, @PathVariable long tripname) {
		return new ResponseEntity<TravelTracker>(this.service.update(id, newMusic), HttpStatus.ACCEPTED);
	}
}