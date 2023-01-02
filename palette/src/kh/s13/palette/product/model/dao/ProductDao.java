package kh.s13.palette.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.vo.CategoryProductVo;
import kh.s13.palette.product.model.vo.ProductDetailVo;
import kh.s13.palette.product.model.vo.ProductVo;

public class ProductDao {
//	insert
	public int insert(Connection conn, ProductVo vo) {
		System.out.println(">>>> ProductDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into product values(?,?,?,?,?,?,?,?)"; // ""안에 ; 는 쓰면 안됨
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
	
//	selectList - 카테고리
	public List<CategoryProductVo> selectList(Connection conn, int cid, String pdelivery, int startprice, int endprice, String sort){
		List<CategoryProductVo> volist = null;
		
		String sql = "	SELECT P.PID, C.CNAME, P.PIMG1, P.PIMG2, P.PNAME, TO_CHAR(P.PPRICE, '999,999,999') PPRICE " // 카테고리이름, 상품이미지, 상품명, 가격
				+ "	    FROM PRODUCT P JOIN CATEGORY C ON P.CID = C.CID"
				+ "	    WHERE P.CID = ?";
		
		// 배송 체크
		if(pdelivery != null && !pdelivery.equals("")) { 
			sql += "		AND P.PDELIVERY = '무료배송'";
		}
		// 가격 체크
		if(!(startprice == 0 && endprice == 99999999)) { 
			sql += "		AND P.PPRICE BETWEEN " + startprice + "AND " + endprice;
		} 
		// 정렬
		switch(sort) {
		case "1": // 낮은가격순
			sql += "		ORDER BY P.PPRICE ASC";
			break;
		case "2": // 높은가격순
			sql += "		ORDER BY P.PPRICE DESC";
			break;
		default: // 기본
			sql += "		ORDER BY P.PNAME ASC";
			break;
		}
		
		System.out.println(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<CategoryProductVo>();
				do {
					CategoryProductVo vo = new CategoryProductVo();
					vo.setPid(rs.getString("pid"));
					vo.setCname(rs.getString("cname"));
					vo.setPimg1(rs.getString("pimg1"));
					vo.setPimg2(rs.getString("pimg2"));
					vo.setPname(rs.getString("pname"));
					vo.setPprice(rs.getString("pprice"));
					
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
	
//	selectOne : 상품상세페이지 상세조회
	public ProductDetailVo selectOne(Connection conn, String pid){
		System.out.println(">>>> ProductDao selectOne param pid : " + pid);
		ProductDetailVo vo = null;
		
		String sql = "SELECT PID, CID, PNAME, PIMG1, PIMG2, TO_CHAR(PPRICE, '999,999,999') PPRICE, PBENEFIT, PDELIVERY, PDETAIL"
				+ "    FROM PRODUCT"
				+ "    WHERE PID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductDetailVo();
				
				vo.setPid(rs.getString("pid"));
				vo.setCid(rs.getInt("cid"));
				vo.setPname(rs.getString("pname"));
				vo.setPimg1(rs.getString("pimg1"));
				vo.setPimg2(rs.getString("pimg2"));
				vo.setPprice(rs.getString("pprice"));
				vo.setPbenefit(rs.getString("pbenefit"));
				vo.setPdelivery(rs.getString("pdelivery"));
				vo.setPdetail(rs.getString("pdetail"));
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
