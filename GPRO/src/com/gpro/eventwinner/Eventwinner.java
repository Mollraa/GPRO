package com.gpro.eventwinner;

public class Eventwinner {
//	WINNER_NUM  NOT NULL VARCHAR2(20)   
//	MEMBER_ID            VARCHAR2(20)   
//	EVENT_TITLE          VARCHAR2(2000) 
	
	private String winnerNum;
	private String memberId;
	private String eventTitle;
	
	public Eventwinner() {
	}

	public String getWinnerNum() {
		return winnerNum;
	}

	public void setWinnerNum(String winnerNum) {
		this.winnerNum = winnerNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	@Override
	public String toString() {
		return "Eventwinner [winnerNum=" + winnerNum + ", memberId=" + memberId + ", eventTitle=" + eventTitle + "]";
	}
	
	

}
