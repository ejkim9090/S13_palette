package kh.s13.palette.review.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.review.model.dao.ReviewDao;
import kh.s13.palette.review.model.dao.ReviewImageDao;
import kh.s13.palette.review.model.vo.MyReviewVo;
import kh.s13.palette.review.model.vo.ProductReviewVo;
import kh.s13.palette.review.model.vo.ReviewImageVo;
import kh.s13.palette.review.model.vo.ReviewVo;

public class ReviewService {

private ReviewDao dao = new ReviewDao();
private ReviewImageDao dao2 = new ReviewImageDao();

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
	public int update(ReviewVo vo, int rno /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ReviewService update param rno :" + rno);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, rno);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService update return :" + result);
		return result;
	}
//	delete
	public int delete(int rno /*여기에는 주로 기본키가 들어감*/) {
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
//	selectList - 내가 작성한 후기
	public List<MyReviewVo> selectMyList(String mid){
		List<MyReviewVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		// 해당되는 rno의 reviewImage만 가져오게하기
		volist = dao.selectMyList(conn, mid);
		if(volist != null) {
			for(int i=0; i < volist.size(); i++) {
				int rno = volist.get(i).getRno();
				List<ReviewImageVo> rimagelist = dao2.selectList(conn, rno);
				volist.get(i).setRimagelist(rimagelist);
			}
		}
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService selectMyList return :" + volist);
		return volist;
	}
//	selectList - 상품 후기
	public List<ProductReviewVo> selectPList(String pid){
		List<ProductReviewVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		// 해당되는 rno의 reviewImage만 가져오게하기
		volist = dao.selectPList(conn, pid);
		if(volist != null) {
			for(int i=0; i < volist.size(); i++) {
				int rno = volist.get(i).getRno();
				List<ReviewImageVo> rimagelist = dao2.selectList(conn, rno);
				volist.get(i).setRimagelist(rimagelist);
			}
		}
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService selectPList return :" + volist);
		return volist;
	}
//	selectOne
	public ReviewVo selectOne(int rno /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ReviewService selectOne param rno :" + rno);
		ReviewVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, rno);
		JdbcTemplate.close(conn);
		System.out.println(">> ReviewService selectOne return :" + vo);
		return vo;
	}
}
