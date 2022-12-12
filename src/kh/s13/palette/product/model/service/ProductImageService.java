package kh.s13.palette.product.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.dao.ProductImageDao;
import kh.s13.palette.product.model.vo.ProductImageVo;

public class ProductImageService {
	
	private ProductImageDao dao = new ProductImageDao();
	
//	insert
	public int insert(ProductImageVo vo) {
		System.out.println(">> ProductImageService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> ProductImageService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	update
	public int update(ProductImageVo vo, String pfilepath /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ProductImageService update param pfilepath :" + pfilepath);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, pfilepath);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductImageService update return :" + result);
		return result;
	}
//	delete
	public int delete(String pfilepath /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> ProductImageService delete param pfilepath :" + pfilepath);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, pfilepath);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductImageService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<ProductImageVo> selectList(){
		List<ProductImageVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductImageService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public ProductImageVo selectOne(String pfilepath /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> ProductImageService selectOne param pfilepath :" + pfilepath);
		ProductImageVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, pfilepath);
		JdbcTemplate.close(conn);
		System.out.println(">> ProductImageService selectOne return :" + vo);
		return vo;
	}
}
