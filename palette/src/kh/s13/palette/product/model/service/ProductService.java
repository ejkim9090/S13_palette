package kh.s13.palette.product.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.dao.ProductDao;
import kh.s13.palette.product.model.vo.ProductVo;

public class ProductService {
	
	private ProductDao dao = new ProductDao();

//	insert
	public int insert(ProductVo vo) {
		System.out.println(">> ProductService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> ProductService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	update
	public int update(ProductVo vo, String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ProductService update param pid :" + pid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductService update return :" + result);
		return result;
	}
//	delete
	public int delete(String pid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ProductService delete param pid :" + pid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<ProductVo> selectList(){
		List<ProductVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public ProductVo selectOne(String pid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ProductService selectOne param pid :" + pid);
		ProductVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, pid);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductService selectOne return :" + vo);
		return vo;
	}
}
