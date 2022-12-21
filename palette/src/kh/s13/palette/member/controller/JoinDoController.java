
package kh.s13.palette.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Mmap;

import kh.s13.palette.member.model.service.MemberService;
import kh.s13.palette.member.model.vo.MemberVo;


/**
 * Servlet implementation class LoginDoController
 */
@WebServlet("/join.do")
public class JoinDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinDoController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		int mgender = 0;
		int mbyear = 0;
		int mbmonth = 0;
		int mbdate = 0;
		int mconsent = 0;
		try {
			mgender = Integer.parseInt(request.getParameter("mgender"));
			mbyear = Integer.parseInt(request.getParameter("mbyear"));
			mbmonth = Integer.parseInt(request.getParameter("mpw"));
			mbdate = Integer.parseInt(request.getParameter("mbdate"));
			mconsent = Integer.parseInt(request.getParameter("mconsent"));
		} catch (Exception e) {
		}
		
		MemberVo vo = new MemberVo(); 
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMname(mname);
		vo.setMemail(memail);
		vo.setMaddr1(maddr1);
		vo.setMaddr2(maddr2);
		vo.setMgender(mgender);
		vo.setMbyear(mbyear);
		vo.setMbmonth(mbmonth);
		vo.setMbdate(mbdate);
		vo.setMconsent(mconsent);
		
		
		int result = new MemberService().insert(vo);
		
		if(result > 0) { 
			System.out.println("회원가입 성공");
			response.sendRedirect(request.getContextPath()+"/login");
		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect(request.getContextPath()+"/join");
		} 
	}

}
