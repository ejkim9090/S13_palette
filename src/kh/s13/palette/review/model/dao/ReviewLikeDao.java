package kh.s13.palette.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.vo.ReviewLikeVo;

public class ReviewLikeDao {

//	insert
	public int insert(Connection conn, ReviewLikeVo vo) {
		System.out.println(">>>> ReviewLikeDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into review_like values(?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRno());
			pstmt.setString(2, vo.getMid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewLikeDao insert return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, int rno, String mid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ReviewLikeDao delete param rno : " + rno);
		System.out.println(">>>> ReviewLikeDao delete param mid : " + mid);
		int result = 0;
		
		String sql = "delete from review_like where rno=? and mid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setString(2, mid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewLikeDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<ReviewLikeVo> selectList(Connection conn){
		List<ReviewLikeVo> volist = null;
		
		String sql = "select * from review_like";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ReviewLikeVo>();
				do {
					ReviewLikeVo vo = new ReviewLikeVo();
					
					vo.setRno(rs.getInt("rno"));
					vo.setMid(rs.getString("mid"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewLikeDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ReviewLikeVo selectOne(Connection conn, int rno, String mid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ReviewLikeDao selectOne param rno : " + rno);
		System.out.println(">>>> ReviewLikeDao selectOne param mid : " + mid);
		ReviewLikeVo vo = null;
		
		String sql = "select * from review_like where rno=? and mid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setString(2, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ReviewLikeVo();
				
				vo.setRno(rs.getInt("rno"));
				vo.setMid(rs.getString("mid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewLikeDao selectOne return : " + vo);
		return vo;
	}
}
