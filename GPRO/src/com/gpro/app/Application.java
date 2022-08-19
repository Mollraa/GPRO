package com.gpro.app;

import java.util.Scanner;

import com.gpro.employee.EmployeeService;
import com.gpro.member.MemberService;

public class Application {
	Scanner sn = new Scanner(System.in);
	EmployeeService es = new EmployeeService(); // 생성자
	MemberService ms = new MemberService();
	public Application() {
		start();
	}

	private void start() {
		while(true) {

		System.out.println("| 1. 로그인 | 2. 회원가입 | 3. 전화문의 | 99. 종료 |");
		String menu = sn.nextLine();
		
		if(menu.equals("1") | menu.contains("로그인")) {
			ms.memberLogin();
			
			System.out.println("| 1.홈(에약) | 2.검색 | 3.게시판 | 4.성장일지 | 5.스토어 | 6.내정보 | 7.문의 | 99.종료 |");
			menu = sn.nextLine();
			switch(menu) {
			case "1":
			case "홈":
			case "예약":
				
				break;
			case "2":
			case "월 레슨매출":
				break;
			case "3":
			case "올해 연습장":
				break;
			case "4":
			case "올해 레슨매출":
				break;
			case "5":
			case "예약인센":
				break;
			case "6":
			case "":
				break;
				
			}
		
		} else if(menu.equals("2") | menu.contains("회원가입")) {
		System.out.println("");
		String a = sn.nextLine();
		switch (a) {
		case "0":
		case "직원등록":
			es.addEmp();
			break;
		case "1":
		case "단건조회":
			es.empFindOne();
			break;	
		case "3":
		case "삭제":
			es.deleteEmp();
			break;
			
		case "2":
		case "정보수정":
			es.empUpdate();
			break;
			
		case "99":
		case "스캐쥴조회":
			break;
			
		case "종료":
		case "q":
			break;

		default:
			break;
		}

	} else if(menu.equals("3") | menu.contains("전화")) {
		System.out.println("전화번호 053-123-1234");
		System.out.println("상담 가능 시간 : 06:00AM - 11:00PM");
	} else if (menu.equals("9")) {
		es.empLogin();
	} else if (menu.equals("99") | menu.contains("종료")) {
		System.out.println("종료되었습니다.");
		break;
	}
		
	} 
	
	
	} // while end
}
