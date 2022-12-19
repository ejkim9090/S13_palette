package kh.s13.palette.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.member.model.vo.MemberVo;

public class MemberDao {

//	insert
	public int insert(Connection conn, MemberVo vo) {
		System.out.println(">>>> MemberDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert into member (mid, mpw, mname, memail, maddr1, maddr2, mgender, mbyear, mbmonth, mbdate, mconsent)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)"; // ""안에 ; 는 쓰면 안됨
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMemail());
			pstmt.setString(5, vo.getMaddr1());
			pstmt.setString(6, vo.getMaddr2());
			pstmt.setInt(7, vo.getMgender());
			pstmt.setInt(8, vo.getMbyear());
			pstmt.setInt(9, vo.getMbmonth());
			pstmt.setInt(10, vo.getMbdate());
			pstmt.setInt(11, vo.getMconsent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> MemberDao insert return : " + result);
		return result;
	}
	
//	update
	public int update(Connection conn, MemberVo vo, String mid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> MemberDao update param vo : " + vo);
		System.out.println(">>>> MemberDao update param mid : " + mid);
		int result = 0;
		
		String sql = "update member set mpw=? memail=? where mid=?"; //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMemail());
			pstmt.setString(3, mid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> MemberDao update return : " + result);
		return result;
	}
	
//	delete
	public int delete(Connection conn, String mid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> MemberDao delete param mid : " + mid);
		int result = 0;
		
		String sql = "delete from member where mid=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> MemberDao delete return : " + result);
		return result;
	}
	
//	selectList : 목록조회 (리턴 모양이 중요!)
	public List<MemberVo> selectList(Connection conn){
		List<MemberVo> volist = null;
		
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<MemberVo>();
				do {
					MemberVo vo = new MemberVo();
					vo.setMid(rs.getString("mid"));
					vo.setMpw(rs.getString("mpw"));
					vo.setMname(rs.getString("mname"));
					vo.setMemail(rs.getString("memail"));
					vo.setMaddr1(rs.getString("maddr1"));
					vo.setMaddr2(rs.getString("maddr2"));
					vo.setMgender(rs.getInt("mpwd"));
					vo.setMbyear(rs.getInt("mbyear"));
					vo.setMbmonth(rs.getInt("mbmonth"));
					vo.setMbdate(rs.getInt("mbdate"));
					vo.setMconsent(rs.getInt("mconsent"));
					vo.setMentrance(rs.getTimestamp("mentrance"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> MemberDao selectList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public MemberVo selectOne(Connection conn, String mid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> MemberDao selectOne param mid : " + mid);
		MemberVo vo = null;
		
		String sql = "select * from member where mid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVo();
				
				vo.setMid(rs.getString("mid"));
				vo.setMpw(rs.getString("mpw"));
				vo.setMname(rs.getString("mname"));
				vo.setMemail(rs.getString("memail"));
				vo.setMaddr1(rs.getString("maddr1"));
				vo.setMaddr2(rs.getString("maddr2"));
				vo.setMgender(rs.getInt("mpwd"));
				vo.setMbyear(rs.getInt("mbyear"));
				vo.setMbmonth(rs.getInt("mbmonth"));
				vo.setMbdate(rs.getInt("mbdate"));
				vo.setMconsent(rs.getInt("mconsent"));
				vo.setMentrance(rs.getTimestamp("mentrance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> MemberDao selectOne return : " + vo);
		return vo;
	}
//	selectOne - login
	public MemberVo login(Connection conn, String mid, String mpw){
		System.out.println(">>>> MemberDao login param mid : " + mid);
		System.out.println(">>>> MemberDao login param mpw : " + mpw);
		MemberVo vo = null;
		
		// 로그인할때 session에 저장할 필요가 있는 항목만. ( * 쓰지 않음. 속도 저하의 원인)
		String sql = "select mid, mname from member where mid=? and mpw=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVo();
				
				// 로그인할때 session에 저장할 필요가 있는 항목만
				vo.setMid(rs.getString("mid"));
				vo.setMname(rs.getString("mname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> MemberDao login return : " + vo);
		return vo;
	}
}
