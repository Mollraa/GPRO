package com.gpro.member;

public class Member {
//	MEMBER_ID    NOT NULL VARCHAR2(20)  
//	MEMBER_PW    NOT NULL VARCHAR2(20)  
//	MEMBER_NAME  NOT NULL VARCHAR2(20)  
//	MEMBER_PHONE NOT NULL VARCHAR2(20)  
//	MEMBER_BIRTH          VARCHAR2(20)  
//	MEMBER_ADDR           VARCHAR2(200) 
//	EMP_ID                VARCHAR2(20)  
//	PRO_NUM               NUMBER  
//	RE_END_DAY            DATE
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberBirth;
	private String memberAddr;
	private String empId;
	private int proNum;
	private String reEndDay;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getReEndDay() {
		return reEndDay;
	}

	public void setReEndDay(String reEndDay) {
		this.reEndDay = reEndDay;
	}

	public int getProNum() {
		return proNum;
	}

	public void setProNum(int proNum) {
		this.proNum = proNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String EmpId) {
		this.empId = EmpId;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + ", memberBirth=" + memberBirth + ", memberAddr=" + memberAddr
				+ ", empId=" + empId + ", proNum=" + proNum + "]";
	}

}
