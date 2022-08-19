package com.gpro.employee;

import java.util.ArrayList;
import java.util.List;

import com.gpro.common.DAO;

public class EmployeeDAO extends DAO {

	private static EmployeeDAO ed = null; // 생성자를 호출해주는 매서드

	private EmployeeDAO() { // 생성자는 무조건대문자 시작!

	}

//	public  EmployeeDAO() { //생성자는 무조건대문자 시작! 
//		
//	}
	public static EmployeeDAO getInstance() { // return
		if (ed == null) {
			ed = new EmployeeDAO();
		}

		return ed;
	}
//	관리자
//	| 0.매출(월(연습장,레슨비), 년(연습장), 예약인센(월,년), 스토어(물건판매 ) 
//	| 1.직원관리(등록(updateEmp)/조회/수정/삭제)
//	| 2. 예약현황(조회/수정/삭제) | 3. 스캐쥴조회 | 99. 종료 |

	//로그인 
	public Employee empLogin(String id) {
		Employee emp = null;
		try {
			conn();
			String sql = "SELECT * FROM employee WHERE emp_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString("emp_id"));
				emp.setEmpPw(rs.getString("emp_pw"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setJobName(rs.getString("job_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return emp;
	}
	// 0.직원관리 - 직원등록
	public int updateEmp(Employee emp) {
		int result = 0;

		try {
//		EMP_ID     NOT NULL VARCHAR2(20)   
//		EMP_PW     NOT NULL VARCHAR2(20)   
//		EMP_NAME   NOT NULL VARCHAR2(20)   
//		EMP_BIRTH           VARCHAR2(20)   
//		EMP_PHONE           VARCHAR2(20)   
//		EMP_ADDR            VARCHAR2(20)   
//		HIRE_DAY            DATE           
//		CAREER              VARCHAR2(4000) 
//		JOB_NAME            VARCHAR2(20)   
//		SALARY              NUMBER         
//		COMMISSION          NUMBER 
// 		ROLE                VARCHAR2(100) 
			conn();

			String sql = "insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,(select max(pro_num from employee)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpPw());
			pstmt.setString(3, emp.getEmpName());
			pstmt.setString(4, emp.getEmpBirth());
			pstmt.setString(5, emp.getEmpPhone());
			pstmt.setString(6, emp.getEmpAddr());
			pstmt.setString(7, emp.getHireDay());
			pstmt.setString(8, emp.getCareer());
			pstmt.setString(9, emp.getJobName());
			pstmt.setInt(10, emp.getSalary());
			pstmt.setDouble(11, emp.getCommission());
			pstmt.setString(12, emp.getRole()); // 가입할때
			pstmt.setString(13, emp.getstoreName());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//1.직원관리 - 조회(전체, 상세)
	public List<Employee> empFindAll() {
		List<Employee> emplist = new ArrayList<>();
		Employee emp = null;

		try {
			conn();
			String sql = "select * from employee";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

//--조회(상세)/emd_id, emp_name, emp_birth, emp_phone, emp_addr, hire_day, career, job_name, salary, commission
//--조회(간편)/emp_id, emp_name, job_name, salary,
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getNString("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpBirth(rs.getString("emp_birth"));
				emp.setEmpPhone(rs.getString("emp_phone"));
				emp.setEmpAddr(rs.getString("emp_addr"));
				emp.setHireDay(rs.getString("hire_day"));
				emp.setCareer(rs.getString("career"));
				emp.setJobName(rs.getString("job_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommission(rs.getDouble("commission"));
				emplist.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emplist;
	}

	// 1.직원관리 - 2조회(2단건조회 : 아이디,직무검색 - 아이디/이름/생년월일/휴대전화/직무/월급/보너스)
	public Employee empFindOne(String id) {
		Employee emp = null;
		try {
			conn();
			String sql = "SELECT * FROM EMPLOYEE WHERE emp_id = ?"; // DML = select / where = 조건문
			// String sql = "SELECT * FROM EMPLOYEE where job_name = ?" // 직무로 검색 하고싶을 떄
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				// 아이디/이름/생년월일/휴대전화/직무/월급/보너스
				emp.setEmpId(rs.getString("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpBirth(rs.getString("emp_birth"));
				emp.setEmpPhone(rs.getString("emp_phone"));
				emp.setEmpAddr(rs.getString("emp_addr"));
				emp.setJobName(rs.getString("job_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommission(rs.getInt("commission"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}
	
	
	//회원 - 번호로 프로선택
	public Employee empPro(int num) {
		Employee emp = null;
		try {
			conn();
			String sql = "SELECT * FROM EMPLOYEE WHERE pro_num = ?"; // DML = select / where = 조건문
			// String sql = "SELECT * FROM EMPLOYEE where job_name = ?" // 직무로 검색 하고싶을 떄
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				// 아이디/이름/생년월일/휴대전화/직무/월급/보너스
				emp.setEmpId(rs.getString("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpBirth(rs.getString("emp_birth"));
				emp.setEmpPhone(rs.getString("emp_phone"));
				emp.setEmpAddr(rs.getString("emp_addr"));
				emp.setJobName(rs.getString("job_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommission(rs.getInt("commission"));
				emp.setProNum(rs.getInt("pro_num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}
	//회원 - 직무검색 
	public List<Employee> empFindPro(String jobname) {
		List<Employee> list = new ArrayList<>();
		Employee emp = null;
		try {
			conn();
			String sql = "SELECT * FROM EMPLOYEE WHERE job_name = ?"; // DML = select / where = 조건문
			// String sql = "SELECT * FROM EMPLOYEE where job_name = ?" // 직무로 검색 하고싶을 떄
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobname);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Employee();
				// 아이디/이름/생년월일/휴대전화/직무/월급/보너스
				emp.setEmpId(rs.getString("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpBirth(rs.getString("emp_birth"));
				emp.setEmpPhone(rs.getString("emp_phone"));
				emp.setEmpAddr(rs.getString("emp_addr"));
				emp.setJobName(rs.getString("job_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCareer(rs.getString("career"));
				emp.setCommission(rs.getInt("commission"));
				emp.setProNum(rs.getInt("pro_num"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//1.직원관리 - 3수정(직원정보수정 : 아이디 검색 -> 이름/휴대전화/주소/월급/comi~)
	public int empUpdate(Employee emp) {
		int result = 0;
		try {
			conn();
			String sql = "update employee set emp_name = ?, emp_phone = ?, emp_addr = ?, salary = ?, commission = ?"
					+ " WHERE emp_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpPhone());
			pstmt.setString(3, emp.getEmpAddr()); // 나중에 지점명으로 바꾸기
			pstmt.setInt(4, emp.getSalary());
			pstmt.setDouble(5, emp.getCommission());
			pstmt.setString(6, emp.getEmpId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	// 1.직원관리 - 4.삭제
	public int deleteEmp(String id) {
		int result = 0;
		try {
			conn();
			// DELETE [FROM] 테이블 명 WHERE 조건
			String sql = "DELETE FROM employee WHERE emp_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

}
