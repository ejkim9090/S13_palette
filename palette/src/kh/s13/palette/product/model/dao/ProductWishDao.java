package kh.s13.palette.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.vo.ProductWishVo;

public class ProductWishDao {

//	insert
	public int insert(Connection conn, ProductWishVo vo) {
		System.out.println(">>>> ProductWishDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into product_wish values(?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductWishDao insert return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, String mid, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ProductWishDao delete param mid : " + mid);
		System.out.println(">>>> ProductWishDao delete param pid : " + pid);
		int result = 0;
		
		String sql = "delete from product_wish where mid=? and pid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductWishDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<ProductWishVo> selectList(Connection conn){
		List<ProductWishVo> volist = null;
		
		String sql = "select * from product_wish";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ProductWishVo>();
				do {
					ProductWishVo vo = new ProductWishVo();
					vo.setMid(rs.getString("mid"));
					vo.setPid(rs.getString("pid"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductWishDao selectList return : " + volist);
		return volist;
	}
	
//	selectList - overloading 내가 찜한 상품
	public List<ProductWishVo> selectList(Connection conn, String mid){
		List<ProductWishVo> volist = null;
		
		String sql = "select * from product_wish where mid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ProductWishVo>();
				do {
					ProductWishVo vo = new ProductWishVo();
					vo.setMid(rs.getString("mid"));
					vo.setPid(rs.getString("pid"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductWishDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ProductWishVo selectOne(Connection conn, String mid, String pid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ProductWishDao selectOne param mid : " + mid);
		System.out.println(">>>> ProductWishDao delete param pid : " + pid);
		ProductWishVo vo = null;
		
		String sql = "select * from product_wish where mid=? and pid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductWishVo();
				
				vo.setMid(rs.getString("mid"));
				vo.setPid(rs.getString("pid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductWishDao selectOne return : " + vo);
		return vo;
	}
}
