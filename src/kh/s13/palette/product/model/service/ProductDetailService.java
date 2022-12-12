package kh.s13.palette.product.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.dao.ProductDetailDao;
import kh.s13.palette.product.model.vo.ProductDetailVo;

public class ProductDetailService {

	private ProductDetailDao dao = new ProductDetailDao();
	
//	insert
	public int insert(ProductDetailVo vo) {
		System.out.println(">> ProductDetailService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> ProductDetailService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	update
	public int update(ProductDetailVo vo, String pdetailname, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ProductDetailService update param pdetailname :" + pdetailname);
		System.out.println(">> ProductDetailService update param pid :" + pid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, pdetailname, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductDetailService update return :" + result);
		return result;
	}
//	delete
	public int delete(String pdetailname, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ProductDetailService delete param pdetailname :" + pdetailname);
		System.out.println(">> ProductDetailService delete param pid :" + pid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, pdetailname, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductDetailService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<ProductDetailVo> selectList(){
		List<ProductDetailVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductDetailService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public ProductDetailVo selectOne(String pdetailname, String pid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ProductDetailService selectOne param pdetailname :" + pdetailname);
		System.out.println(">> ProductDetailService selectOne param pid :" + pid);
		ProductDetailVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, pdetailname, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductDetailService selectOne return :" + vo);
		return vo;
	}
}
