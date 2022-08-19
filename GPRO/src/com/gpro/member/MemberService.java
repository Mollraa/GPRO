package com.gpro.member;

import java.util.Scanner;

import com.gpro.employee.Employee;
import com.gpro.employee.EmployeeDAO;
import com.gpro.employee.EmployeeService;

public class MemberService {
	public static Member memInfo = null;
	Scanner sn = new Scanner(System.in);
	EmployeeService es = new EmployeeService();
//	 | 1. 로그인 | 2. 회원가입 | 3. 전화문의 | 4. 종료 |
//
//	>> 로그인 후 메인
//	| 1.홈 | 2.검색 | 3.게시판 | 4.성장일지 | 5.스토어 | 6.내정보 | 7.문의 | 99.종료 |
//
//	>> 홈
//	| 0.타석예약 | 1.레슨예약 | 2.라운딩예약 | 3.우리연습장 프로님조회 | 99. 종료 |
		
	//회원가입 
	public void addMember() {
//	MEMBER_ID    NOT NULL VARCHAR2(20)  
//	MEMBER_PW    NOT NULL VARCHAR2(20)  
//	MEMBER_NAME  NOT NULL VARCHAR2(20)  
//	MEMBER_PHONE NOT NULL VARCHAR2(20)  
//	MEMBER_BIRTH          VARCHAR2(20)  
//	MEMBER_ADDR           VARCHAR2(200) 
//	EMP_ID                VARCHAR2(20)   //결제할때 ?
		Member mem = new Member();
		
		System.out.println("사용하실 ID를 입력해주세요 > ");
		String id = sn.nextLine();
		
		System.out.println("비밀번호를 입력해주세요 >");
		String pw = sn.nextLine();

		System.out.println("성함을 입력해주세요 >");
		String name = sn.nextLine();

		System.out.println("휴대전화를 입력해주세요 >");
		String phoe = sn.nextLine();
		
		System.out.println("생년월일을 입력해주세요 >");
		String bir = sn.nextLine();

		System.out.println("주소를 입력해주세요 >");
		String add = sn.nextLine();
		
//		System.out.println("프로님 목록보기 "); //여기서부터 emp에서 들고옴
//		es.empFindPro("pro"); //프로목록 보여주는 줄
//		System.out.println("원하시는 프로님의 번호를 선택해 주세요~^^~");
//		int proNum = Integer.parseInt(sn.nextLine());
//		
//		Employee pro = EmployeeDAO.getInstance().empPro(proNum);
		
		mem.setMemberId(id);
		mem.setMemberPw(pw);
		mem.setMemberName(name);
		mem.setMemberPhone(phoe);
		mem.setMemberBirth(bir);
		mem.setMemberAddr(add);
		mem.setEmpId("연습장만");
		mem.setProNum(0);
	
//		System.out.println("확인용");
//		String r = sn.nextLine();
		
		int result = MemberDAO.getInstance().addMember(mem);
		if(result == 1) {
			System.out.println("환영합니다~! 회원가입이 완료되었습니다. ^^");
		} else {
			System.out.println("회원가입이 정상적으로 되지 않았습니다.");
		}
		System.out.println("-----------------------------");
		System.out.println();
		
	}
	//1.로그인
	public void memberLogin() {
		Member mem = new Member();
		System.out.println("ID를 입력하세요 > ");
		String id = sn.nextLine();
		System.out.println("PW를 입력하세요 > ");
		String pw = sn.nextLine();
		
		mem = MemberDAO.getInstance().memLogin(id);
		
		if(mem.getMemberPw().equals(pw)) {
			System.out.println("로그인 완료!");
			memInfo = mem;
		}
	}
}
