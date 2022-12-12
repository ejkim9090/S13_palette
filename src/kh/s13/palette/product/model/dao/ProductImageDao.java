package kh.s13.palette.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.vo.ProductImageVo;

public class ProductImageDao {

//	insert
	public int insert(Connection conn, ProductImageVo vo) {
		System.out.println(">>>> ProductImageDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into product_image values(?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPfilepath());
			pstmt.setString(2, vo.getPid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductImageDao insert return : " + result);
		return result;
	}
	
//	update
	public int update(Connection conn, ProductImageVo vo, String pfilepath /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ProductImageDao update param vo : " + vo);
		System.out.println(">>>> ProductImageDao update param pfilepath : " + pfilepath);
		int result = 0;
		
		String sql = "update product_image set pid=? where pfilepath=?"; //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPid());
			pstmt.setString(2, pfilepath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductImageDao update return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, String pfilepath /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ProductImageDao delete param pfilepath : " + pfilepath);
		int result = 0;
		
		String sql = "delete from product_image where pfilepath=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pfilepath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductImageDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<ProductImageVo> selectList(Connection conn){
		List<ProductImageVo> volist = null;
		
		String sql = "select * from product_image";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ProductImageVo>();
				do {
					ProductImageVo vo = new ProductImageVo();
					vo.setPfilepath(rs.getString("pfilepath"));
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
		System.out.println(">>>> ProductImageDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ProductImageVo selectOne(Connection conn, String pfilepath /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ProductImageDao selectOne param pfilepath : " + pfilepath);
		ProductImageVo vo = null;
		
		String sql = "select * from product_image where pfilepath=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pfilepath);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductImageVo();
				
				vo.setPfilepath(rs.getString("pfilepath"));
				vo.setPid(rs.getString("pid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductImageDao selectOne return : " + vo);
		return vo;
	}
}
