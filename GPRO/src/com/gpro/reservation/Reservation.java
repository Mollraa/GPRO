package com.gpro.reservation;

public class Reservation {
//	SEAT_NUM           VARCHAR2(1000) 
//	SEAT_TIME          VARCHAR2(1000) 
	private int reNum;
	private String memberId;
	private String startDay;
	private String endDay;
	private int rePrice;
	private String payDay;
	private String reName;
	private String seatNum;
	private String seatTime;

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getSeatTime() {
		return seatTime;
	}

	public void setSeatTime(String seatTime) {
		this.seatTime = seatTime;
	}

	public int getReNum() {
		return reNum;
	}

	public void setReNum(int reNum) {
		this.reNum = reNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public int getRePrice() {
		return rePrice;
	}

	public void setRePrice(int rePrice) {
		this.rePrice = rePrice;
	}

	public String getPayDay() {
		return payDay;
	}

	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}

	public String getReName() {
		return reName;
	}

	public void setReName(String reName) {
		this.reName = reName;
	}

	@Override
	public String toString() {
		return "Reservation [reNum=" + reNum + ", memberId=" + memberId + ", startDay=" + startDay + ", endDay="
				+ endDay + ", rePrice=" + rePrice + ", payDay=" + payDay + ", reName=" + reName + "]";
	}

}
