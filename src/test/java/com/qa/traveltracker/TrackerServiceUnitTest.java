package com.qa.traveltracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.traveltracker.domain.TravelTracker;
import com.qa.traveltracker.repo.TravelTrackerRepo;
import com.qa.traveltracker.service.TrackerService;

@RunWith(MockitoJUnitRunner.class)
public class TrackerServiceUnitTest {

	@InjectMocks
	private TrackerService service;

	@Mock
	private TravelTrackerRepo repo;

	@Test
	public void createTest() {​​​
	TravelTracker input = new TravelTracker("plane", "uk", 0600, "germany", 1500);
	TravelTracker output = new TravelTracker(1L, "plane", "uk", 0600, "germany", 1500);
	
	Mockito.when(this.repo.save(input)).thenReturn(output);
	
	assertEquals(output, this.service.create(input));
	
	Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}​ ​
​
}
}

