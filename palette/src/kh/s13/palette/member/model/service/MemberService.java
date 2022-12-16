package kh.s13.palette.member.model.service;

import java.sql.Connection;
import java.util.List;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.member.model.dao.MemberDao;
import kh.s13.palette.member.model.vo.MemberVo;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
//	insert
	public int insert(MemberVo vo) {
		System.out.println(">> MemberService insert param vo :" + vo);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		System.out.println(">> MemberService insert return :" + result);
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
//	update
	public int update(MemberVo vo, String mid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> MemberService update param mid :" + mid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, mid);
		JdbcTemplate.close(conn);
		System.out.println(">> MemberService update return :" + result);
		return result;
	}
//	delete
	public int delete(String mid /*여기에는 주로 기본키가 들어감*/) {
		System.out.println(">> MemberService delete param mid :" + mid);
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, mid);
		JdbcTemplate.close(conn);
		System.out.println(">> MemberService delete return :" + result);
		return result;
	}
//	selectList (리턴 모양이 중요!)
	public List<MemberVo> selectList(){
		List<MemberVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		System.out.println(">> MemberService selectList return :" + volist);
		return volist;
	}
//	selectOne
	public MemberVo selectOne(String mid /*여기에는 주로 기본키가 들어감*/){
		System.out.println(">> MemberService selectOne param mid :" + mid);
		MemberVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, mid);
		JdbcTemplate.close(conn);
		System.out.println(">> MemberService selectOne return :" + vo);
		return vo;
	}
}
