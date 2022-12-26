package kh.s13.palette.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.member.model.vo.MemberVo;
import kh.s13.palette.product.model.service.ProductWishService;

/**
 * Servlet implementation class MypageReviewDeleteDoController
 */
@WebServlet("/mypage_wish_delete.lo")
public class MypageWishDeleteLoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageWishDeleteLoController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 찜 삭제
		PrintWriter out = response.getWriter();
		
		String mid = ((MemberVo)request.getSession().getAttribute("loginSsInfo")).getMid();
		String pid = request.getParameter("pid"); 
		
		ProductWishService service = new ProductWishService();
		int result = service.delete(mid, pid);
		
		System.out.println(result);
		out.println(result);
		out.flush();
		out.close(); 
	}

}
