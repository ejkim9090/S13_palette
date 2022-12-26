package kh.s13.palette.product.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.product.model.dao.CategoryDao;
import kh.s13.palette.product.model.vo.CategoryVo;

public class CategoryService {
	
	private CategoryDao dao = new CategoryDao(); 
	
//	insert
	public int insert(CategoryVo vo) {
		System.out.println(">> CategoryService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> CategoryService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	update
	public int update(CategoryVo vo, String cid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> CategoryService update param cid :" + cid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, cid);
		JdbcTemplate.close(conn);
		System.out.println(">> CategoryService update return :" + result);
		return result;
	}
//	delete
	public int delete(String cid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> CategoryService delete param cid :" + cid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, cid);
		JdbcTemplate.close(conn);
		System.out.println(">> CategoryService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<CategoryVo> selectList(){
		List<CategoryVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> CategoryService selectList return :" + volist);
		return volist;
	}
//	selectList (리턴 모양이 중요!)
	public List<CategoryVo> selectList(int cpid){
		List<CategoryVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn, cpid);
		JdbcTemplate.close(conn);
		System.out.println(">> CategoryService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public CategoryVo selectOne(String cid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> CategoryService selectOne param cid :" + cid);
		CategoryVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, cid);
		JdbcTemplate.close(conn);
		System.out.println(">> CategoryService selectOne return :" + vo);
		return vo;
	}
}
