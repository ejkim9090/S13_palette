package kh.s13.palette.review.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.dao.ReviewImageDao;
import kh.s13.palette.review.model.vo.ReviewImageVo;

public class ReviewImageService {

	private ReviewImageDao dao = new ReviewImageDao();
	
//	insert
	public int insert(ReviewImageVo vo) {
		System.out.println(">> ReviewImageService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> ReviewImageService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	delete
	public int delete(String rfilepath) {
		System.out.println(">> ReviewImageService delete param rfilepath :" + rfilepath);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, rfilepath);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewImageService delete return :" + result);
		return result;
	}
//	delete - overloading 후기번호에 해당하는사진 다 삭제
	public int delete(int rno) {
		System.out.println(">> ReviewImageService delete param rno :" + rno);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, rno);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewImageService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<ReviewImageVo> selectList(){
		List<ReviewImageVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewImageService selectList return :" + volist);
		return volist;
	}
//	selectList - overloading
	public List<ReviewImageVo> selectList(int rno){
		List<ReviewImageVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn, rno);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewImageService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public ReviewImageVo selectOne(String rfilepath /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ReviewImageService selectOne param rfilepath :" + rfilepath);
		ReviewImageVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, rfilepath);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewImageService selectOne return :" + vo);
		return vo;
	}
}
