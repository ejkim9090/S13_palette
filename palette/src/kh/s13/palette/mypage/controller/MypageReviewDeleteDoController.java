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
 * Servlet implementation class MypageReviewDeleteDoController
 */
@WebServlet("/mypage/review/delete.do")
public class MypageReviewDeleteDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageReviewDeleteDoController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 작성한 후기 삭제
		
		String rnoStr = request.getParameter("rno"); // 후기 번호
		int rno = 0;
		try {
			rno = Integer.parseInt(rnoStr);
		}catch (Exception e) {
		}
		
		ReviewService service = new ReviewService();
		int result = service.delete(rno);
		
		if (result > 0) {
			request.setAttribute("rno", rno);
			request.setAttribute("func", "reviewDelete");
			request.setAttribute("msg", "후기 삭제 성공");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		} else {
			request.setAttribute("rno", rno);
			request.setAttribute("func", "reviewDelete");
			request.setAttribute("msg", "후기 삭제 실패");
			request.getRequestDispatcher("./WEB-INF/view/resultAlert.jsp").forward(request, response);
		}
	}

}
