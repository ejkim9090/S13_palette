package kh.s13.palette.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.vo.ProductDetailVo;

public class ProductDetailDao {

//	insert
	public int insert(Connection conn, ProductDetailVo vo) {
		System.out.println(">>>> ProductDetailDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into product_detail values(?,?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPdetailname());
			pstmt.setString(2, vo.getPid());
			pstmt.setString(3, vo.getPdetailcontent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDetailDao insert return : " + result);
		return result;
	}
	
//	update
	public int update(Connection conn, ProductDetailVo vo, String pdetailname, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ProductDetailDao update param vo : " + vo);
		System.out.println(">>>> ProductDetailDao update param pdetailname : " + pdetailname);
		System.out.println(">>>> ProductDetailDao update param pid : " + pid);
		int result = 0;
		
		String sql = "update product_detail set pdetailcontent=? where pdetailname=? and pid=?"; //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPdetailcontent());
			pstmt.setString(2, pdetailname);
			pstmt.setString(3, pid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDetailDao update return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, String pdetailname, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ProductDetailDao delete param pdetailname : " + pdetailname);
		System.out.println(">>>> ProductDetailDao update param pid : " + pid);
		int result = 0;
		
		String sql = "delete from product_detail where pdetailname=? and pid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdetailname);
			pstmt.setString(2, pid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDetailDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<ProductDetailVo> selectList(Connection conn){
		List<ProductDetailVo> volist = null;
		
		String sql = "select * from product_detail";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ProductDetailVo>();
				do {
					ProductDetailVo vo = new ProductDetailVo();
					vo.setPdetailname(rs.getString("pdetailname"));
					vo.setPid(rs.getString("pid"));
					vo.setPdetailcontent(rs.getString("pdetailcontent"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDetailDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ProductDetailVo selectOne(Connection conn, String pdetailname, String pid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ProductDetailDao selectOne param pdetailname : " + pdetailname);
		System.out.println(">>>> ProductDetailDao update param pid : " + pid);
		ProductDetailVo vo = null;
		
		String sql = "select * from product_detail where pdetailname=? and pid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdetailname);
			pstmt.setString(2, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductDetailVo();
				
				vo.setPdetailname(rs.getString("pdetailname"));
				vo.setPid(rs.getString("pid"));
				vo.setPdetailcontent(rs.getString("pdetailcontent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDetailDao selectOne return : " + vo);
		return vo;
	}
}
