package com.gpro.diary;

public class Diary {

	private String diaryNum;
	private String diaryTitle;
	private String diaryMain;
	private String memberId;
	private String diaryFid;
	private String diaryComment;

	public Diary() {
	}

	public String getDiaryNum() {
		return diaryNum;
	}

	public void setDiaryNum(String diaryNum) {
		this.diaryNum = diaryNum;
	}

	public String getDiaryTitle() {
		return diaryTitle;
	}

	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public String getDiaryMain() {
		return diaryMain;
	}

	public void setDiaryMain(String diaryMain) {
		this.diaryMain = diaryMain;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getDiaryFid() {
		return diaryFid;
	}

	public void setDiaryFid(String diaryFid) {
		this.diaryFid = diaryFid;
	}

	public String getDiaryComment() {
		return diaryComment;
	}

	public void setDiaryComment(String diaryComment) {
		this.diaryComment = diaryComment;
	}

	@Override
	public String toString() {
		return "Diary [diaryNum=" + diaryNum + ", diaryTitle=" + diaryTitle + ", diaryMain=" + diaryMain + ", memberId="
				+ memberId + ", diaryFid=" + diaryFid + ", diaryComment=" + diaryComment + "]";
	}

}
