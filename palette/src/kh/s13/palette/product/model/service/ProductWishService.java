package kh.s13.palette.product.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.dao.ProductWishDao;
import kh.s13.palette.product.model.vo.MyProductWishVo;
import kh.s13.palette.product.model.vo.ProductWishVo;

public class ProductWishService {

	private ProductWishDao dao = new ProductWishDao();

//	insert
	public int insert(ProductWishVo vo) {
		System.out.println(">> ProductWishService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> ProductWishService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	delete
	public int delete(String mid, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ProductWishService delete param mid :" + mid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, mid, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductWishService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<ProductWishVo> selectList(){
		List<ProductWishVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductWishService selectList return :" + volist);
		return volist;
	}
//	selectList - overloading 내가 찜한 상품
	public List<MyProductWishVo> selectList(String mid){
		List<MyProductWishVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn, mid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductWishService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public ProductWishVo selectOne(String mid, String pid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ProductWishService selectOne param mid :" + mid);
		ProductWishVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, mid, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductWishService selectOne return :" + vo);
		return vo;
	}
}
