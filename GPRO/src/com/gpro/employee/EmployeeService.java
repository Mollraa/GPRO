package com.gpro.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gpro.app.Application;

public class EmployeeService {
	public static Employee empInfo = null;
	Scanner sn = new Scanner(System.in);

	// 로그인
	public void empLogin() {
		Employee emp = new Employee();

		System.out.println("ID를 입력하세요 > ");
		String id = sn.nextLine();
		System.out.println("PW를 입력하세요 > ");
		String pw = sn.nextLine();

		emp = EmployeeDAO.getInstance().empLogin(id);

		try {
			if (emp != null) {
				empInfo = emp;
			} else {
				System.out.println("아이디를 확인해 주세요.");
			}
			
			if (emp.getEmpPw().equals(pw)) {
				System.out.println("로그인 성공.");
				new Application();
			} else {
				System.out.println("비빌번호가 틀렸습니다.");
			}
		} catch (Exception e) {
			System.out.println("다시 시도해 주십시오.");
		}
	}
	//로그아웃
	

	// 1.직원관리(1등록)
	public void addEmp() {
		Employee emp = new Employee();
		System.out.println("직원 ID를 입력하세요 >> ");
		String id = sn.nextLine();

		System.out.println("직원 PW를 입력하세요 >>");
		String pw = sn.nextLine();

		System.out.println("직원 이름을 입력하세요 >>");
		String name = sn.nextLine();

		System.out.println("직원 생년월일을 입력하세요 >>");
		String bir = sn.nextLine();

		System.out.println("직원 휴대전화를 입력하세요 >>");
		String phoe = sn.nextLine();

		System.out.println("직원 주소를 입력하세요 >>");
		String add = sn.nextLine();

		System.out.println("직원 입사일을 입력하세요 >>");
		String hire = sn.nextLine();

		System.out.println("직원 경력을 입력하세요 >>");
		String career = sn.nextLine();

		System.out.println("직원 직무를 입력하세요 >>");
		String jName = sn.nextLine();

		System.out.println("직원 급여를 입력하세요 >>");
		int sal = Integer.parseInt(sn.nextLine());

		System.out.println("직원 보너스 입력하세요 >>");
		double comi = Double.parseDouble(sn.nextLine());

		System.out.println("직원 직급을 입력하세요 >>");
		String role = sn.nextLine();

		System.out.println("지점명을 입력하세요 > ");
		String sname = sn.nextLine();
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
//		ROLE                VARCHAR2(100)
		emp.setEmpId(id);
		emp.setEmpPw(pw);
		emp.setEmpName(name);
		emp.setEmpBirth(bir);
		emp.setEmpPhone(phoe);
		emp.setEmpAddr(add);
		emp.setHireDay(hire);
		emp.setCareer(career);
		emp.setJobName(jName);
		emp.setSalary(sal);
		emp.setCommission(comi);
		emp.setRole(role);
		emp.setstoreName(sname);

		int rr = EmployeeDAO.getInstance().updateEmp(emp);
		if (rr == 1) {
			System.out.println("직원이 등록되었습니다.");
		} else {
			System.out.println("직원 등록 실패.");
		}
	}

	// 1.직원관리 - 2조회(1전체조회- 2상세)
	public void empFindAll() {
		List<Employee> emplist = new ArrayList<>(); // ArrayList 배열의기능?정렬? 등등
		Employee emp = null;
//--조회(상세)/emd_id, emp_name, emp_birth, emp_phone, emp_addr, 
//			hire_day, career, job_name, salary, commission
		System.out.println("| 1. 상세조회 | 2.간편조회 |");
		String name = sn.nextLine();

		if (name.equals("1") | name.contains("상세")) {
			System.out.println("상세조회 실행 중 입니다.");
			emplist = EmployeeDAO.getInstance().empFindAll();
			for (Employee e : emplist) {
				System.out.println(e);
			}

		} else if (name.equals("2") | name.contains("간편")) { // contains~ 포함하는단어 있으면 ok
			System.out.println("간편조회 실행 중 입니다.");
			// --조회(간편)/emp_id, emp_name, job_name, salary
			emplist = EmployeeDAO.getInstance().empFindAll();
			for (Employee e : emplist) {
//				e.getEmpId();
//				e.getEmpName();
//				e.getJobName();
//				e.getSalary();
				System.out.println("-----------------------------");
				System.out.println("직원 ID : " + e.getEmpId());
				System.out.println("직원 이름 : " + e.getEmpName());
				System.out.println("직무 : " + e.getJobName());
				System.out.println("월급 : " + e.getSalary());
				System.out.println("-----------------------------");
			}
		}
	}

	// 1.직원관리 - 2조회(2단건조회 : 이름검색 - 아이디/이름/생년월일/휴대전화/직무/월급/보너스)
	public void empFindOne() {
		Employee emp = new Employee();
		try {

			System.out.println("조회할 직원 ID를 입력하세요 > ");
			String id = sn.nextLine();

			emp = EmployeeDAO.getInstance().empFindOne(id);
			System.out.println("-----------------------------");
			System.out.println("ID > " + emp.getEmpId());
			System.out.println("이름 > " + emp.getEmpName());
			System.out.println("생년월일 > " + emp.getEmpBirth());
			System.out.println("휴대전화 > " + emp.getEmpPhone());
			System.out.println("주소 > " + emp.getEmpAddr()); // 지점으로 바꾸면 더 나을듯 ? 아님 지점을 추가ㅇㅇ
			System.out.println("직무 > " + emp.getJobName());
			System.out.println("월급 > " + emp.getSalary());
			System.out.println("보너스 > " + emp.getCommission());
			System.out.println("-----------------------------");

		} catch (Exception e) {
			System.out.println("존재하지 않는 직원ID 입니다.");
			System.out.println("-----------------------------");
		}
	}

	// 단건조회 - 직무검색 (pro)
	public void empFindPro(String jobname) {
		List<Employee> list = new ArrayList<>();
		Employee empp = new Employee();
		try {
			list = EmployeeDAO.getInstance().empFindPro(jobname);
			for (Employee emp : list) {
				System.out.println("-----------------------------");
				System.out.println("NUMBER " + emp.getProNum());
				System.out.println("이름 > " + emp.getEmpName());
				System.out.println("휴대전화 > " + emp.getEmpPhone());
				System.out.println("직무 > " + emp.getJobName());
				System.out.println("경력 > " + emp.getCareer());
				System.out.println("-----------------------------");
			}
		} catch (Exception e) {
			System.out.println("존재하지 않는 직무 입니다.");
			System.out.println("-----------------------------");
		}
	}

	// 1.직원관리 - 3수정(직원정보수정 : 아이디 검색 -> 이름/휴대전화/주소/월급/comi~)
	public void empUpdate() { // O,X
		Employee emp = new Employee();

		System.out.println("직원 ID를 입력하세요 > ");
		String id = sn.nextLine();

		System.out.println("수정할 직원 이름 > ");
		String name = sn.nextLine();

		System.out.println("수정할 직원 휴대전화 > ");
		String phone = sn.nextLine();

		System.out.println("수정할 직원 주소 > ");
		String add = sn.nextLine();

		System.out.println("수정할 직원 월급 > ");
		int sal = Integer.parseInt(sn.nextLine());

		System.out.println("수정할 보너스 > ");
		double comi = Double.parseDouble(sn.nextLine());

		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setEmpPhone(phone);
		emp.setEmpAddr(add);
		emp.setSalary(sal);
		emp.setCommission(comi);

		int e = EmployeeDAO.getInstance().empUpdate(emp);

		if (e == 1) {
			System.out.println("수정 성공! >_< !!!");
		} else {
			System.out.println("수정 실패 ㅜ^ㅜ ... ");
		}
	}

	// 1.직원관리 - 4.삭제
	public void deleteEmp() {
		System.out.println("삭제할 직원 ID > ");
		String id = sn.nextLine();
		try {

			Employee emp = EmployeeDAO.getInstance().empFindOne(id);

			int e = EmployeeDAO.getInstance().deleteEmp(emp.getEmpId());
			if (e == 1) {
				System.out.println("성공적으로 삭제 되었습니다.");
			} else {
				System.out.println("삭제에 실패하였습니다.");
			}
		} catch (Exception e) {
			System.out.println("존재하지 않는 직원ID 입니다.");
		}

	}
}
