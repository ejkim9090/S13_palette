package kh.s13.palette.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.vo.MyReviewVo;
import kh.s13.palette.review.model.vo.ProductReviewVo;
import kh.s13.palette.review.model.vo.ReviewImageVo;
import kh.s13.palette.review.model.vo.ReviewVo;

public class ReviewDao {

//	insert
	public int insert(Connection conn, ReviewVo vo, List<String> rfilepathlist) {
		System.out.println(">>>> ReviewDao insert param : " + vo);
		int result = 0;
		
		String sql = "insert all"
				+ " into review (rno, pid, mid, rcontent) values (maxrno, ?, ?, ?)";
		if(rfilepathlist != null) {
			for(String rfilepath : rfilepathlist ) {
		sql		+= " into review_image values (maxrno, '"+rfilepath+"')";
			}
		}
		
		sql		+= " select NVL(max(rno), 0)+1 as maxrno from review"; // ""안에 ; 는 쓰면 안됨
		
		System.out.println("review sql:"+ sql);
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPid());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getRcontent());
			
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
	public int update(Connection conn, ReviewVo vo, int rno /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ReviewDao update param vo : " + vo);
		System.out.println(">>>> ReviewDao update param rno : " + rno);
		int result = 0;
		
		String sql = "update review set rcontent=? where rno=?"; //TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRcontent());
			pstmt.setInt(2, rno);
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
	public int delete(Connection conn, int rno /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">>>> ReviewDao delete param rno : " + rno);
		int result = 0;
		
		String sql = "delete from review where rno=?";
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
//	selectList - 내가 작성한 후기목록 페이징
	public List<MyReviewVo> selectMyList(Connection conn, String mid, int startRnum, int endRnum){
		List<MyReviewVo> volist = null;
		
		String sql = "select * "
				+ "	   	from (select t1.*, rownum r"
				+ "	   	from (SELECT R.RNO, P.PID, P.PIMG1, P.PNAME, R.RCONTENT, TO_CHAR(R.RDATE, 'YYYY.MM.DD') RDATE" // 후기번호, 상품아이디, 상품이미지, 상품명, 후기내용, 글등록시간
				+ "    	FROM REVIEW R JOIN PRODUCT P ON R.PID = P.PID"
				+ "    	WHERE R.MID = ?"
				+ "    	ORDER BY R.RNO DESC) t1 ) t2 "
				+ "		where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<MyReviewVo>();
				do {
					MyReviewVo vo = new MyReviewVo();
					vo.setRno(rs.getInt("rno"));
					vo.setPid(rs.getString("pid"));
					vo.setPimg1(rs.getString("pimg1"));
					vo.setPname(rs.getString("pname"));
					vo.setRcontent(rs.getString("rcontent").replaceAll("%%", "<br>"));
					vo.setRdate(rs.getString("rdate"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewDao selectMyList return : " + volist);
		return volist;
	}
	
//	selectList - 상품페이지 후기목록
	public List<ProductReviewVo> selectPList(Connection conn, String pid, int startRnum, int endRnum){
		List<ProductReviewVo> volist = null;
		
		String sql = "select * "
				+ "		from (select t1.*, rownum r "
				+ "		from (SELECT R.RNO, M.MNAME, P.PNAME, R.RCONTENT, TO_CHAR(R.RDATE, 'YYYY.MM.DD') RDATE" // 후기번호, 회원이름, 상품명, 후기내용, 글등록시간
				+ "     FROM REVIEW R JOIN PRODUCT P ON R.PID = P.PID"
				+ "                   JOIN MEMBER M ON R.MID = M.MID"
				+ "     WHERE R.PID = ?"
				+ "     ORDER BY R.RNO DESC) t1 ) t2"
				+ "		where r between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				volist = new ArrayList<ProductReviewVo>();
				do {
					ProductReviewVo vo = new ProductReviewVo();
					vo.setRno(rs.getInt("rno"));
					vo.setMname(rs.getString("mname"));
					vo.setPname(rs.getString("pname"));
					vo.setRcontent(rs.getString("rcontent").replaceAll("%%", "<br>"));
					vo.setRdate(rs.getString("rdate"));
					
					volist.add(vo);
				} while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println(">>>> ReviewDao selectPList return : " + volist);
		return volist;
	}
	
//	selectOne : 하나 상세조회
	public ReviewVo selectOne(Connection conn, int rno /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">>>> ReviewDao selectOne param rno : " + rno);
		ReviewVo vo = null;
		
		String sql = "select * from review where rno=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
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
// selectTotalCnt : 나의 후기 총 개수
	public int selectTotalCnt(Connection conn, String mid) {
		int result = 0;
		
		String sql = "select count(*) from review where mid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1); // 1 : 첫번째 컬럼 (여기선 컬럼이 하나)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
// selectPTotalCnt : 상품 후기 총 개수
	public int selectPTotalCnt(Connection conn, String pid) {
		int result = 0;
		
		String sql = "select count(*) from review where pid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1); // 1 : 첫번째 컬럼 (여기선 컬럼이 하나)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
}
