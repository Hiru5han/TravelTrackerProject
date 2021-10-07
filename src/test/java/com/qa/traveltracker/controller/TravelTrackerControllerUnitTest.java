package com.qa.traveltracker.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.traveltracker.domain.TravelTracker;
import com.qa.traveltracker.service.TrackerService;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TravelTrackerControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private TrackerService service;

	@Test
	public void createTest() throws Exception {
		TravelTracker entry = new TravelTracker("plane", "UK", 1300, "Germany", 2000);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.create(entry)).thenReturn(entry);

		mvc.perform(post("/traveltracker/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(entryAsJSON));
	}

	@Test
	public void readAllTest() throws Exception {
		TravelTracker entry = new TravelTracker("plane", "UK", 1300, "Germany", 2000);
		List<TravelTracker> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = this.mapper.writeValueAsString(output);

		Mockito.when(this.service.readAll()).thenReturn(output);

		mvc.perform(get("/traveltracker/readAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void readTest() throws Exception {
		TravelTracker entry = new TravelTracker("plane", "UK", 1300, "Germany", 2000);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.read(1L)).thenReturn(entry);

		mvc.perform(get("/traveltracker/read/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(entryAsJSON));
	}

	@Test
	public void deleteSuccessTest() throws Exception {
		Mockito.when(this.service.delete(1L)).thenReturn(true);

		mvc.perform(delete("/traveltracker/remove/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

	@Test
	public void deleteFailTest() throws Exception {
		Mockito.when(this.service.delete(1L)).thenReturn(false);

		mvc.perform(delete("/traveltracker/remove/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}

	@Test
	public void updateTest() throws Exception {
		TravelTracker entry = new TravelTracker("plane", "UK", 1300, "Germany", 2000);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.update(entry, 1L)).thenReturn(entry);

		mvc.perform(put("/traveltracker/update/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isAccepted()).andExpect(content().json(entryAsJSON));
	}
}
