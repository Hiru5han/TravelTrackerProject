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
@RequestMapping("/traveltracker")
public class TravelTrackerController {

	private TrackerService service;

	public TravelTrackerController(TrackerService service) {
		super();
		this.service = service;
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<TravelTracker> createTracker(@RequestBody TravelTracker tracker) {
		return new ResponseEntity<TravelTracker>(this.service.create(tracker), HttpStatus.CREATED);
	}

	// READ ALL
	@GetMapping("/readAll")
	public ResponseEntity<List<TravelTracker>> readAll() {
		return new ResponseEntity<List<TravelTracker>>(this.service.readAll(), HttpStatus.OK);
	}

	// READ ONE
	@GetMapping("/read/{id}")
	public ResponseEntity<TravelTracker> read(@PathVariable long id) {
		return new ResponseEntity<TravelTracker>(this.service.read(id), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<TravelTracker> update(@PathVariable long id, @RequestBody TravelTracker tracker) {
		return new ResponseEntity<TravelTracker>(this.service.update(tracker, id), HttpStatus.ACCEPTED);
	}

}
