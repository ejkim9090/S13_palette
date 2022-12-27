package kh.s13.palette.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.vo.ReviewImageVo;

public class ReviewImageDao {

//	insert
	public int insert(Connection conn, ReviewImageVo vo) {
		System.out.println(">>>> ReviewImageDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into review_image values(?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRfilepath());
			pstmt.setInt(2, vo.getRno());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewImageDao insert return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, String rfilepath /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ReviewImageDao delete param rfilepath : " + rfilepath);
		int result = 0;
		
		String sql = "delete from review_image where rfilepath=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rfilepath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewImageDao delete return : " + result);
		return result;
	}
//	delete - overloading 후기번호에 해당하는사진 다 삭제
	public int delete(Connection conn, int rno) {
		System.out.println(">>>> ReviewImageDao delete param rno : " + rno);
		int result = 0;
		
		String sql = "delete from review_image where rno=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewImageDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<ReviewImageVo> selectList(Connection conn){
		List<ReviewImageVo> volist = null;
		
		String sql = "select * from review_image";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ReviewImageVo>();
				do {
					ReviewImageVo vo = new ReviewImageVo();
					
					vo.setRfilepath(rs.getString("rfilepath"));
					vo.setRno(rs.getInt("rno"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewImageDao selectList return : " + volist);
		return volist;
	}
	
//	selectList - overloading
	public List<ReviewImageVo> selectList(Connection conn, int rno){
		List<ReviewImageVo> volist = null;
		
		String sql = "select RFILEPATH from review_image where rno=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ReviewImageVo>();
				do {
					ReviewImageVo vo = new ReviewImageVo();
					vo.setRfilepath(rs.getString("rfilepath"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewImageDao selectList return : " + volist);
		return volist;
	}
	
//	selectList - overloading 상품상세페이지 사진 더보기
	public List<ReviewImageVo> selectList(Connection conn, String pid){
		List<ReviewImageVo> volist = null;
		
		String sql = "SELECT * "
				+ "    FROM REVIEW_IMAGE I JOIN REVIEW R ON I.RNO = R.RNO"
				+ "    WHERE R.PID = ?"
				+ "	   ORDER BY R.RDATE DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ReviewImageVo>();
				do {
					ReviewImageVo vo = new ReviewImageVo();
					vo.setRno(rs.getInt("rno"));
					vo.setRfilepath(rs.getString("rfilepath"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewImageDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ReviewImageVo selectOne(Connection conn, String rfilepath /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ReviewImageDao selectOne param rfilepath : " + rfilepath);
		ReviewImageVo vo = null;
		
		String sql = "select * from review_image where rfilepath=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rfilepath);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ReviewImageVo();
				
				vo.setRfilepath(rs.getString("rfilepath"));
				vo.setRno(rs.getInt("rno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewImageDao selectOne return : " + vo);
		return vo;
	}
}
