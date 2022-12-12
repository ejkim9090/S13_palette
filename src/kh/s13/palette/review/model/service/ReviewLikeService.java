package kh.s13.palette.review.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.dao.ReviewLikeDao;
import kh.s13.palette.review.model.vo.ReviewLikeVo;

public class ReviewLikeService {

	private ReviewLikeDao dao = new ReviewLikeDao();
	
//	insert
	public int insert(ReviewLikeVo vo) {
		System.out.println(">> ReviewLikeService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> ReviewLikeService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	delete
	public int delete(int rno, String mid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ReviewLikeService delete param rno :" + rno);
		System.out.println(">> ReviewLikeService delete param mid :" + mid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, rno, mid);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewLikeService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<ReviewLikeVo> selectList(){
		List<ReviewLikeVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewLikeService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public ReviewLikeVo selectOne(int rno, String mid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ReviewLikeService selectOne param rno :" + rno);
		System.out.println(">> ReviewLikeService selectOne param mid :" + mid);
		ReviewLikeVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, rno, mid);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewLikeService selectOne return :" + vo);
		return vo;
	}
}
