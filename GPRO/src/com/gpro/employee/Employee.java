package com.gpro.employee;

public class Employee {
	//컬럼에 지점명 추가하기, 여기도 하고 직원 조회 / 수정 에 각각 추가해주기 
//	STORE_NAME          VARCHAR2(50)   
//	PRO_NUM             NUMBER        
	private String empId;
	private String empPw;
	private String empName;
	private String empBirth;
	private String empPhone;
	private String empAddr;
	private String hireDay;
	private String career;
	private String JobName;
	private int salary;
	private double commission;
	private String role;
	private String storeName;
	private int proNum;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpBirth() {
		return empBirth;
	}

	public void setEmpBirth(String empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public String getHireDay() {
		return hireDay;
	}

	public void setHireDay(String hireDay) {
		this.hireDay = hireDay;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getJobName() {
		return JobName;
	}

	public void setJobName(String jobName) {
		JobName = jobName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public String getstoreName() {
		return storeName;
	}

	public void setstoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getProNum() {
		return proNum;
	}

	public void setProNum(int proNum) {
		this.proNum = proNum;
	}

	@Override
	public String toString() {
//--조회(상세)/emd_id, emp_name, emp_birth, emp_phone, emp_addr,
//			hire_day, career, job_name, salary, commission
		return "직원관리 [직원 ID : " + empId + ", 이름 : " + empName + ", 생년월일 : " + empBirth + ", 휴대전화 : " + empPhone
				+ ", 주소 : " + empAddr + ", 입사일 : " + hireDay + ", 경력 : " + career + ", 직무 : " + JobName + ", 월금 : "
				+ salary + ", 보너스 : " + commission + " ,지점명 : " + storeName + "]";
	}

}
