package com.gpro.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gpro.member.MemberDAO;
import com.gpro.member.MemberService;

public class ReservationService {
	Scanner sn = new Scanner(System.in);
//	| 1.홈(예약) | 2.검색 | 3.게시판 | 4.성장일지 | 5.스토어 | 6.내정보 | 7.문의 | 99.종료 |
//	>> 홈
//	| 0.타석예약 | 1.레슨예약 | 2.라운딩예약 | 3.우리연습장 프로님조회 | 99. 종료 |

	public void reserSeat() {
		List<Reservation>list = new ArrayList<>();
		Reservation reser = new Reservation();
//		 >0-1. 좌석시간(당일)
//		 좌석번호(당일)(우리연습장 -> 1일/기간 -> 좌석선택 -> 6~12 (90분) -> 
//		 06:00 ~ 07:30 A
//		 07:30 ~ 09:00 B
//		 09:00 ~ 10:30 C
//		 10:30 ~ 12:00 D
//		 12:00 ~ 01:30 F
//		 01:30 ~ 03:00 G
//		 03:00 ~ 04:30 H
//		 04:30 ~ 06:00 I ... 
//		(좌석선택 > 완료)
//		 1□ 2■ 3□ 4■ 5□ 6□ 7□ 8□ 9■ 10□
		list = ReservationDAO.getInstance().reserCheck("타석예약",String day, String time);
		
		System.out.println("06:00 ~ 07:30 | A");
		System.out.println("07:30 ~ 09:00 | B");
		System.out.println("09:00 ~ 10:30 | C");
		System.out.println("10:30 ~ 12:00 | D");
		System.out.println("ㅅ ㅣ간을 선택해주세요.. ");
		String time = sn.nextLine();
		
		
		
		System.out.println("1□");
		System.out.println("2■");
		System.out.println("3□ 4■ 5□ 6□ 7□ 8□ 9■ 10□");
		System.out.println("1□ 2■ 3□ 4■ 5□ 6□ 7□ 8□ 9■ 10□");
		
		System.out.println("타석 번호를 선택해 주세요 > ");
		String num = sn.nextLine();

		if (MemberService.memInfo.getReEndDay() == null) {
			reser.setRePrice(20000);
		} else {
			reser.setRePrice(0);
		}
		String id = MemberService.memInfo.getMemberId(); // 로그인한 상태에서 정보불러올때

		System.out.println("방문 시간을 입력해주세요 > ");

		reser.setSeatTime(time);
		reser.setSeatNum(num);
		reser.setMemberId(id);
		reser.setReName("타석예약");
	 	
		int result = ReservationDAO.getInstance().addSeat(reser);
		if(result == 1) {
			System.out.println("타석예약이 완료되었습니다.");
		} else if (result == 0) {
			System.out.println("응꺼졍");		
		}

	}

}
