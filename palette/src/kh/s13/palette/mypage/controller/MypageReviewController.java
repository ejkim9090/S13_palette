package kh.s13.palette.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.member.model.vo.MemberVo;
import kh.s13.palette.review.model.service.ReviewService;
import kh.s13.palette.review.model.vo.ReviewVo;

/**
 * Servlet implementation class MypageWishController
 */
@WebServlet("/mypage/review")
public class MypageReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageReviewController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 작성한 후기 목록
		String mid = ((MemberVo)request.getSession().getAttribute("loginSsInfo")).getMid();
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		try {
			rno = Integer.parseInt(rnoStr);
		}catch (Exception e) {
		}
		
		
		ReviewService service = new ReviewService();
		List<ReviewVo> volist = service.selectList(mid);
		
		request.setAttribute("reviewList", volist);
		
		// 해당되는 rno의 reviewImage만 가져오게하는 작업은 ReviewService에서

		String viewPath = "/WEB-INF/view/mypage_review.jsp";
		request.getRequestDispatcher(viewPath).forward(request, response);// 이부분만 계속 바꿔서 사용하면됨. 여기엔 <%=request.getContextPath()%> 작성 안함 (forward방식은 애초에 contextpath가 유지가 됨)
	
	}


}
