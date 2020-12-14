package NotFinished;

import java.sql.Time;

public class TimeSlot {
	
	private Integer timeSlot_id;
	private String weekDay;
	private String name;
	private Time startTime;
	private Time endTime;

	

	public TimeSlot() {
	}



	public TimeSlot(Integer timeSlot_id, String weekDay, String name, Time startTime, Time endTime) {
		super();
		this.timeSlot_id = timeSlot_id;
		this.weekDay = weekDay;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}



	public Integer getTimeSlot_id() {
		return timeSlot_id;
	}



	public void setTimeSlot_id(Integer timeSlot_id) {
		this.timeSlot_id = timeSlot_id;
	}



	public String getWeekDay() {
		return weekDay;
	}



	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Time getStartTime() {
		return startTime;
	}



	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}



	public Time getEndTime() {
		return endTime;
	}



	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	
	
}
