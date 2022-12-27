package kh.s13.palette.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.vo.CategoryVo;

public class CategoryDao {

//	insert
	public int insert(Connection conn, CategoryVo vo) {
		System.out.println(">>>> CategoryDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into category values(?,?,?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCid());
			pstmt.setString(2, vo.getCname());
			pstmt.setInt(3, vo.getCdepth());
			pstmt.setInt(4, vo.getCpid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> CategoryDao insert return : " + result);
		return result;
	}
	
//	update
	public int update(Connection conn, CategoryVo vo, int cid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> CategoryDao update param vo : " + vo);
		System.out.println(">>>> CategoryDao update param mid : " + cid);
		int result = 0;
		
		String sql = "update category set cname=? where cid=?"; //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCname());
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> CategoryDao update return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, int cid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> CategoryDao delete param cid : " + cid);
		int result = 0;
		
		String sql = "delete from category where cid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> CategoryDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<CategoryVo> selectList(Connection conn){
		List<CategoryVo> volist = null;
		
		String sql = "select * from category";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<CategoryVo>();
				do {
					CategoryVo vo = new CategoryVo();
					vo.setCid(rs.getInt("cid"));
					vo.setCname(rs.getString("cname"));
					vo.setCdepth(rs.getInt("cdepth"));
					vo.setCpid(rs.getInt("cpid"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> CategoryDao selectList return : " + volist);
		return volist;
	}
//	selectList - overriding 소분류 조회
	public List<CategoryVo> selectList(Connection conn, int cpid){
		List<CategoryVo> volist = null;
		
		String sql = "select cid, cname from category where cpid=?"; // 카테고리아이디, 카테고리이름
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cpid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<CategoryVo>();
				do {
					CategoryVo vo = new CategoryVo();
					vo.setCid(rs.getInt("cid"));
					vo.setCname(rs.getString("cname"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> CategoryDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public CategoryVo selectOne(Connection conn, int cid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> CategoryDao selectOne param cid : " + cid);
		CategoryVo vo = null;
		
		String sql = "select * from category where cid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new CategoryVo();
				
				vo.setCid(rs.getInt("cid"));
				vo.setCname(rs.getString("cname"));
				vo.setCdepth(rs.getInt("cdepth"));
				vo.setCpid(rs.getInt("cpid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> CategoryDao selectOne return : " + vo);
		return vo;
	}
//	selectParent : 부모카테고리
	public CategoryVo selectParent(Connection conn, int cid){
		System.out.println(">>>> CategoryDao selectParent param cid : " + cid);
		CategoryVo vo = null;
		
		String sql = "select * from category where cid = (select cpid from category where cid = ?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new CategoryVo();
				
				vo.setCid(rs.getInt("cid"));
				vo.setCname(rs.getString("cname"));
				vo.setCdepth(rs.getInt("cdepth"));
				vo.setCpid(rs.getInt("cpid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> CategoryDao selectParent return : " + vo);
		return vo;
	}
}
