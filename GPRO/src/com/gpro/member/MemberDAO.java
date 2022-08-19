package com.gpro.member;

import com.gpro.common.DAO;

public class MemberDAO extends DAO {

	private static MemberDAO md = new MemberDAO(); //변수들은 모아 놓은 필드를 만들어줌
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return md;
	}

//	 | 1. 로그인 | 2. 회원가입 | 3. 전화문의 | 4. 종료 |
//
//	>> 로그인 후 메인
//	| 1.홈(예약) | 2.검색 | 3.게시판 | 4.성장일지 | 5.스토어 | 6.내정보 | 7.문의 | 99.종료 |
//	>> 홈
//	| 0.타석예약 | 1.레슨예약 | 2.라운딩예약 | 3.우리연습장 프로님조회 | 99. 종료 |

	//회원가입 
	public int addMember(Member mem) {
		int result = 0;
		try {
			conn();
//			MEMBER_ID    NOT NULL VARCHAR2(20)  
//			MEMBER_PW    NOT NULL VARCHAR2(20)  
//			MEMBER_NAME  NOT NULL VARCHAR2(20)  
//			MEMBER_PHONE NOT NULL VARCHAR2(20)  
//			MEMBER_BIRTH          VARCHAR2(20)  
//			MEMBER_ADDR           VARCHAR2(200) 
//			EMP_ID                VARCHAR2(20)  
//			PRO_NUM               NUMBER  
			String sql = "insert into member values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getMemberPhone());
			pstmt.setString(5, mem.getMemberBirth());
			pstmt.setString(6, mem.getMemberAddr());
			pstmt.setString(7, mem.getEmpId());
			pstmt.setInt(8, mem.getProNum());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}return result;
	}
	public Member memLogin(String id) {
		Member mem = null; //생성자호출
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //DB에서 가져온 sql문 결과값 담겨있음
			
			while(rs.next()) {
//				MEMBER_ID    NOT NULL VARCHAR2(20)  
//				MEMBER_PW    NOT NULL VARCHAR2(20)  
//				MEMBER_NAME  NOT NULL VARCHAR2(20)  
//				MEMBER_PHONE NOT NULL VARCHAR2(20)  
//				MEMBER_BIRTH          VARCHAR2(20) 
//				MEMBER_ADDR           VARCHAR2(200) 
//				EMP_ID                VARCHAR2(20) 
//				PRO_NUM               NUMBER 
//				RE_END_DAY            DATE
				mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberPhone(rs.getString("member_phone"));
				mem.setMemberBirth(rs.getString("member_birth"));
				mem.setMemberAddr(rs.getString("member_addr"));
				mem.setEmpId(rs.getString("emp_id"));
				mem.setProNum(rs.getInt("pro_num"));
				mem.setReEndDay(rs.getString("re_end_day"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} return mem;
		
	}
}
