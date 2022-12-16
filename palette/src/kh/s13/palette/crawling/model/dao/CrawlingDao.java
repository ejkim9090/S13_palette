package kh.s13.palette.crawling.model.dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.vo.ProductVo;

public class CrawlingDao {
	
	public int insertProduct(Connection conn, ProductVo vo) {
		
		System.out.println("CrawlingDao insertProduct");
		int result = 0;
		
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";
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
//			pstmt.setClob(9, vo.getPdetail()); // 이방법 비추..
//			pstmt.setString(9, vo.getPdetail()); // 위에 to_clob(?) -> 이것도 안됨.. 
			// CLOB 변환 방법
			Clob clob = conn.createClob(); 
			clob.setString(9, vo.getPdetail());
			pstmt.setClob(9, clob);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		return result;
	}	
	
	
}
