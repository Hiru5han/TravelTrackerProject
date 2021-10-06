package com.qa.traveltracker.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TravelTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Travel method can not be null")
	private String travelMethod;

	@NotNull(message = "Travel start time can not be null")
	private int startTime;

	@NotNull(message = "Travel finish time can not be null")
	private int finishTime;

	@NotNull(message = "Start destination can not be null")
	private String startDestination;

	@NotNull(message = "Finish destination can not be null")
	private String finishDestination;

	// Default constructor
	public TravelTracker() {
		super();
	}

	// For creating
	public TravelTracker(String travelMethod, String startDestination, int startTime, String finishDestination, int finishTime) {
		super();
		this.travelMethod = travelMethod;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.startDestination = startDestination;
		this.finishDestination = finishDestination;

	}

	// For testing
	public TravelTracker(long id, String travelMethod, @NotNull(message = "Start destination can not be null") String startDestination, int startTime, @NotNull(message = "Finish destination can not be null") String finishDestination, int finishTime) {
		super();
		this.id = id;
		this.travelMethod = travelMethod;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.startDestination = startDestination;
		this.finishDestination = finishDestination;
	}

	public String getTravelMethod() {
		return travelMethod;
	}

	public void setTravelMethod(String travelMethod) {
		this.travelMethod = travelMethod;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public String getStartDestination() {
		return startDestination;
	}

	public void setStartDestination(@NotNull(message = "Start destination can not be null") String startDestination) {
		this.startDestination = startDestination;
	}

	public String getFinishDestination() {
		return finishDestination;
	}

	public void setFinishDestination(@NotNull(message = "Finish destination can not be null") String finishDestination) {
		this.finishDestination = finishDestination;
	}

	@Override
	public String toString() {
		return "You're travelling by " + travelMethod + ", leaving from " + startDestination + " at " + startTime
				+ " and you'll get to " + finishDestination + " at " + finishTime + ". Have a safe trip!";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, travelMethod, startTime, finishTime, startDestination, finishDestination);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelTracker other = (TravelTracker) obj;
		return Objects.equals(travelMethod, other.travelMethod) && id == other.id && startTime == other.startTime
				&& Objects.equals(finishTime, other.finishTime)
				&& Objects.equals(startDestination, other.startDestination)
				&& Objects.equals(finishDestination, other.finishDestination);
	}
}