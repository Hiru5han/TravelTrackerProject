package com.qa.traveltracker.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.traveltracker.domain.TravelTracker;
import com.qa.traveltracker.repo.TravelTrackerRepo;

@RunWith(MockitoJUnitRunner.class)
public class TrackerServiceUnitTest {

	@InjectMocks
	private TrackerService service;

	@Mock
	private TravelTrackerRepo repo;

	@Test
	public void createTest() {
		TravelTracker input = new TravelTracker("plane", "UK", 1300, "Germany", 2000);
		TravelTracker output = new TravelTracker(1L, "plane", "UK", 1300, "Germany", 2000);

		Mockito.when(this.repo.save(input)).thenReturn(output);

		assertEquals(output, this.service.create(input));

		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}

	@Test
	public void readAllTest() {
		List<TravelTracker> output = new ArrayList<>();
		output.add(new TravelTracker("plane", "UK", 1300, "Germany", 2000));

		Mockito.when(this.repo.findAll()).thenReturn(output);

		assertEquals(output, this.service.readAll());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void readOneTest() {
		Optional<TravelTracker> OptionalOutput = Optional
				.of(new TravelTracker(1L, "plane", "UK", 1300, "Germany", 2000));
		TravelTracker output = new TravelTracker(1L, "plane", "UK", 1300, "Germany", 2000);

		Mockito.when(this.repo.findById(1L)).thenReturn(OptionalOutput);

		assertEquals(output, this.service.read(1L));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void updateTest() {
		TravelTracker input = new TravelTracker("plane", "France", 1300, "Germany", 2000);
		Optional<TravelTracker> existing = Optional.of(new TravelTracker(1L, "plane", "UK", 1300, "Germany", 2000));
		TravelTracker output = new TravelTracker(1L, "plane", "France", 1300, "Germany", 2000);

		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);

		assertEquals(output, this.service.update(input, 1L));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
	}

	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);

		assertTrue(this.service.delete(1L));

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}

	@Test
	public void deleteFalseTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(true);

		assertFalse(this.service.delete(1L));

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}

}
