package com.gpro.board;

public class Board {
//	B_NUM         NOT NULL VARCHAR2(20)   
//	MEMBER_ID     NOT NULL VARCHAR2(20)   
//	CONTENT_VIEWS          NUMBER         
//	CONTENT_TITLE          VARCHAR2(20)   
//	CONTENT_DAY            DATE           
//	CONTENT_MAIN               VARCHAR2(4000) 
//	ROLE                   VARCHAR2(100)  
//	REPORT                 VARCHAR2(4000) 
//	REPORT_NUM             NUMBER     
	
	private String bNum;
	private String memberId;
	private int contentViews;
	private String contentTitle;
	private String contentDay;
	private String contentMain;
	private String role;
	private String report;
	private int reportNum;
	
	public Board() {
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getContentViews() {
		return contentViews;
	}

	public void setContentViews(int contentViews) {
		this.contentViews = contentViews;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentDay() {
		return contentDay;
	}

	public void setContentDay(String contentDay) {
		this.contentDay = contentDay;
	}

	public String getContentMain() {
		return contentMain;
	}

	public void setContentMain(String contentMain) {
		this.contentMain = contentMain;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public int getReportNum() {
		return reportNum;
	}

	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}

	@Override
	public String toString() {
		return "Board [bNum=" + bNum + ", memberId=" + memberId + ", contentViews=" + contentViews + ", contentTitle="
				+ contentTitle + ", contentDay=" + contentDay + ", contentMain=" + contentMain + ", role=" + role
				+ ", report=" + report + ", reportNum=" + reportNum + "]";
	}
	
	

}
