package com.gpro.event;

public class Event {
	private int eventNum;
	private String eventTitle;
	private String eventMain;
	private String eventStart;
	private String eventEnd;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventMain() {
		return eventMain;
	}

	public void setEventMain(String eventMain) {
		this.eventMain = eventMain;
	}

	public String getEventStart() {
		return eventStart;
	}

	public void setEventStart(String eventStart) {
		this.eventStart = eventStart;
	}

	public String getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(String eventEnd) {
		this.eventEnd = eventEnd;
	}

	@Override
	public String toString() {
		return "Event [eventNum=" + eventNum + ", eventTitle=" + eventTitle + ", eventMain=" + eventMain
				+ ", eventStart=" + eventStart + ", eventEnd=" + eventEnd + "]";
	}
	
	

}
