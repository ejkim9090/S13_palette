package kh.s13.palette.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.vo.ProductVo;

public class ProductDao {
//	insert
	public int insert(Connection conn, ProductVo vo) {
		System.out.println(">>>> ProductDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPid());
			pstmt.setInt(2, vo.getCid());
			pstmt.setString(3, vo.getPname());
			pstmt.setString(4, vo.getPimage1());
			pstmt.setString(5, vo.getPimage2());
			pstmt.setInt(6, vo.getPprice());
			pstmt.setString(7, vo.getPbenefit());
			pstmt.setString(8, vo.getPdelivery());
			pstmt.setString(9, vo.getPintro());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDao insert return : " + result);
		return result;
	}
	
//	update
	public int update(Connection conn, ProductVo vo, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ProductDao update param vo : " + vo);
		System.out.println(">>>> ProductDao update param pid : " + pid);
		int result = 0;
		
		String sql = "update product set pprice=? where pid=?"; //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPprice());
			pstmt.setString(2, pid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDao update return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ProductDao delete param pid : " + pid);
		int result = 0;
		
		String sql = "delete from product where pid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<ProductVo> selectList(Connection conn){
		List<ProductVo> volist = null;
		
		String sql = "select * from product";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ProductVo>();
				do {
					ProductVo vo = new ProductVo();
					vo.setPid(rs.getString("pid"));
					vo.setCid(rs.getInt("cid"));
					vo.setPname(rs.getString("pname"));
					vo.setPimage1(rs.getString("pimage1"));
					vo.setPimage2(rs.getString("pimage2"));
					vo.setPprice(rs.getInt("pprice"));
					vo.setPbenefit(rs.getString("pbenefit"));
					vo.setPdelivery(rs.getString("pdelivery"));
					vo.setPintro(rs.getString("pintro"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ProductVo selectOne(Connection conn, String pid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ProductDao selectOne param pid : " + pid);
		ProductVo vo = null;
		
		String sql = "select * from product where pid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductVo();
				
				vo.setPid(rs.getString("pid"));
				vo.setCid(rs.getInt("cid"));
				vo.setPname(rs.getString("pname"));
				vo.setPimage1(rs.getString("pimage1"));
				vo.setPimage2(rs.getString("pimage2"));
				vo.setPprice(rs.getInt("pprice"));
				vo.setPbenefit(rs.getString("pbenefit"));
				vo.setPdelivery(rs.getString("pdelivery"));
				vo.setPintro(rs.getString("pintro"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ProductDao selectOne return : " + vo);
		return vo;
	}
}
