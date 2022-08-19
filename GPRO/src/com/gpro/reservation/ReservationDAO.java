package com.gpro.reservation;

import java.util.ArrayList;
import java.util.List;

import com.gpro.common.DAO;

public class ReservationDAO extends DAO {
	private static ReservationDAO rd = null;

	private ReservationDAO() {

	}

	public static ReservationDAO getInstance() {
		if (rd == null) {
			rd = new ReservationDAO();
		}
		return rd;
	}

//	| 1.홈(예약) | 2.검색 | 3.게시판 | 4.성장일지 | 5.스토어 | 6.내정보 | 7.문의 | 99.종료 |
//	>> 홈
//	| 0.타석예약 | 1.레슨예약 | 2.라운딩예약 | 3.우리연습장 프로님조회 | 99. 종료 |
	public List<Reservation> reserSeat() {
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
//		 11□ 12■ 13□ 14■ 15□ 16□ 17□ 18■ 19□ 20■
		List<Reservation> list = new ArrayList<>();
		try {
			conn();
			String sql = "SELECT * FROM Reservation WHERE member_id = ? ";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

// 타석예약 
	public int addSeat(Reservation r) {
		int result = 0;
		try {
			conn();
//			reser.setSeatTime(time);
//			reser.setSeatNum(num);
//			reser.setMemberId(id);
//			reser.setReName("타석예약");
			String sql = "insert into reservation(seat_time, seat_num, member_id, re_name, re_price)"
					+ " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getSeatTime());
			pstmt.setString(2, r.getSeatNum());
			pstmt.setString(3, r.getMemberId());
			pstmt.setString(4, r.getReName());
			pstmt.setInt(5, r.getRePrice());
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	//예약종류별 조회
	public List<Reservation> reserCheck(String name, String day , String time) {
//		 >0-1. 좌석시간(당일)
//		 좌석번호(당일)(우리연습장 -> 1일/기간 -> 좌석선택 ->
//		 07:30 ~ 09:00 B
//		 09:00 ~ 10:30 C
//		 10:30 ~ 12:00 D
//		 12:00 ~ 01:30 F
//		 01:30 ~ 03:00 G
//		 03:00 ~ 04:30 H
//		 04:30 ~ 06:00 I ... 
//		(좌석선택 > 완료)
//		 1□ 2■ 3□ 4■ 5□ 6□ 7□ 8□ 9■ 10□
//		 11□ 12■ 13□ 14■ 15□ 16□ 17□ 18■ 19□ 20■
		List<Reservation> list = new ArrayList<>();
		Reservation reser = null;
		try {
			conn();
			String sql = "SELECT * FROM Reservation WHERE re_name = ? and  Start_day=?  and, seat_time=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, day);
			pstmt.setString(3, time);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reser = new Reservation();
				reser.setStartDay(rs.getString("start_day"));
				reser.setReNum(rs.getInt("re_num"));
				reser.setSeatTime(rs.getString("seat_time"));
				list.add(reser);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	
	
}
