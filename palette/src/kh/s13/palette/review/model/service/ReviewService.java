package kh.s13.palette.review.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.dao.ReviewDao;
import kh.s13.palette.review.model.vo.ReviewVo;

public class ReviewService {

private ReviewDao dao = new ReviewDao();
	
//	insert
	public int insert(ReviewVo vo) {
		System.out.println(">> ReviewService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> ReviewService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	update
	public int update(ReviewVo vo, String rno /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ReviewService update param rno :" + rno);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, rno);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService update return :" + result);
		return result;
	}
//	delete
	public int delete(String rno /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ReviewService delete param rno :" + rno);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, rno);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<ReviewVo> selectList(){
		List<ReviewVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public ReviewVo selectOne(String rno /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ReviewService selectOne param rno :" + rno);
		ReviewVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, rno);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService selectOne return :" + vo);
		return vo;
	}
}
