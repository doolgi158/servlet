package com.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.common.DBUtil.getConnection;

/*	SubjectDAO 클래스 (Data Access Object)
 * 
 * 이 클래스는 데이터베이스의 subject 테이블에 접근하여 학과 정보를 처리하는 모든 기능을 담당한다.
 * 
 * 주된 기능은 다음과 같다: CRUD 프로그램
 * - Create (입력): 새로운 학과 정보 추가
 * - Read	(조회): 학과 목록 조회 및 검색
 * - Update (수정): 학과 정보 변경
 * - Delete (삭제): 학과 정보 삭제
 * 
 * 이 DAO 클래스는 실제 데이터 처리의 최종 단계로서, 비즈니스 로직과 데이터베이스 간의 연결을 책임진다.*/
public class SubjectDAO {
	// 클래스 자신의 타입으로 정적 필드 선언
	private static SubjectDAO instance = null;
	
	// 외부에서 호출할 수 있는 정적 메소드인 getInstance() 선언하여 인스턴스를 반환.
	public static SubjectDAO getInstance() {
		if(instance == null) {
			instance = new SubjectDAO();
		}
		return instance;
	}
	
	// 외부에서 new 연산자로 생성자를 호출할 수 없도록 막기 위해 접근 제한자(private) 설정
	private SubjectDAO() {	}
	
	// 위 내용을 메서드로 분리하여 구현하면
	private SubjectVO addSubject(ResultSet rs) throws SQLException {
		SubjectVO subjectVO = new SubjectVO();
		subjectVO.setNo(rs.getInt("no"));
		subjectVO.setSubjectNumber(rs.getString("s_num"));
		subjectVO.setSubjectName(rs.getString("s_name"));
		return subjectVO;
	}
	
	public List<SubjectVO> getAllSubjects() {
		List<SubjectVO> list = new ArrayList<>();
		String sql = "SELECT NO, S_NUM, S_NAME FROM SUBJECT ORDER BY NO";
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
			
			while (rs.next()) {
				list.add(addSubject(rs));
			}
		}catch(SQLException e) {
			//System.err.println("[getAllSubjects] SQL 오류: " + e.getMessage());
			e.printStackTrace();	//오류 발생 시 주석 해제
		}
		return list;
	}


	public String getSubjectNumber() {
		String subjectNumber = "";
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NVL(TO_CHAR(MAX(S_NUM) + 1, 'FM00'), '01')");
		sql.append("AS subjectNum FROM SUBJECT");
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();){
			
			if(rs.next()) {
				subjectNumber = rs.getString("subjectNum");
			}
		}catch(SQLException se) {
			System.err.println("[getSubjectNumber] SQL 오류: " + se.getMessage());
			//se.printStackTrace();
		}
		return subjectNumber;
	}
	
	public boolean subjectInsert(SubjectVO subjectVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO SUBJECT(NO, S_NUM, S_NAME) ");
		sql.append("VALUES(SUBJECT_SEQ.NEXTVAL, ?, ?)");
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setString(1, subjectVO.getSubjectNumber());	// 첫번째 ?(바인딩변수) 설정값 - 학과번호
			pstmt.setString(2, subjectVO.getSubjectName());	// 두번째 ?(바인딩변수) 설정값 - 학과명
			
			return pstmt.executeUpdate() == 1;
		}catch(SQLException se) {
			System.err.println("[subjectInsert] SQL 오류: " + se.getMessage());
			//se.printStackTrace();	// 오류 발생 시 주석 해제
			return false;
		}
	}
	
	public boolean subjectUpdate(SubjectVO subjectVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE SUBJECT SET S_NAME = ? ");
		sql.append("WHERE S_NUM = ?");
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, subjectVO.getSubjectName());
			pstmt.setString(2, subjectVO.getSubjectNumber());
			
			return pstmt.executeUpdate() == 1;
		}catch(SQLException se) {
			System.err.println("[subjectUpdate] SQL 오류: " + se.getMessage());
			//se.printStackTrace();	// 오류 발생 시 주석 해제
			return false;
		}
	}
	
	public boolean subjectDelete(SubjectVO subjectVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM SUBJECT ");
		sql.append("WHERE S_NUM = ?");
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, subjectVO.getSubjectNumber());
			
			return pstmt.executeUpdate() == 1;
		}catch(SQLException se) {
			System.err.println("[subjectUpdate] SQL 오류: " + se.getMessage());
			//se.printStackTrace();	// 오류 발생 시 주석 해제
			return false;
		}
	}
}
