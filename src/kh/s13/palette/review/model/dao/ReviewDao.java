package kh.s13.palette.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.vo.ReviewVo;

public class ReviewDao {

//	insert
	public int insert(Connection conn, ReviewVo vo) {
		System.out.println(">>>> ReviewDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into review values(?,?,?,?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRno());
			pstmt.setString(2, vo.getPid());
			pstmt.setString(3, vo.getMid());
			pstmt.setString(4, vo.getRcontent());
			pstmt.setTimestamp(5, vo.getRdate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewDao insert return : " + result);
		return result;
	}
	
//	update
	public int update(Connection conn, ReviewVo vo, String rno /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ReviewDao update param vo : " + vo);
		System.out.println(">>>> ReviewDao update param rno : " + rno);
		int result = 0;
		
		String sql = "update review set rcontent=? where rno=?"; //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRcontent());
			pstmt.setString(2, rno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewDao update return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, String rno /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ReviewDao delete param rno : " + rno);
		int result = 0;
		
		String sql = "delete from review where rno=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<ReviewVo> selectList(Connection conn){
		List<ReviewVo> volist = null;
		
		String sql = "select * from review";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ReviewVo>();
				do {
					ReviewVo vo = new ReviewVo();
					vo.setRno(rs.getInt("rno"));
					vo.setPid(rs.getString("pid"));
					vo.setMid(rs.getString("mid"));
					vo.setRcontent(rs.getString("rcontent"));
					vo.setRdate(rs.getTimestamp("rdate"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ReviewVo selectOne(Connection conn, String rno /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ReviewDao selectOne param rno : " + rno);
		ReviewVo vo = null;
		
		String sql = "select * from review where rno=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ReviewVo();
				
				vo.setRno(rs.getInt("rno"));
				vo.setPid(rs.getString("pid"));
				vo.setMid(rs.getString("mid"));
				vo.setRcontent(rs.getString("rcontent"));
				vo.setRdate(rs.getTimestamp("rdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewDao selectOne return : " + vo);
		return vo;
	}
}
