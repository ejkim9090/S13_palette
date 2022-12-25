package kh.s13.palette.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.review.model.service.ReviewImageService;
import kh.s13.palette.review.model.service.ReviewService;

/**
 * Servlet implementation class MypageReviewDeleteDoController
 */
@WebServlet("/mypage_review_delete.lo")
public class MypageReviewDeleteLoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageReviewDeleteLoController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 작성한 후기 삭제
		PrintWriter out = response.getWriter();
		
		String rnoStr = request.getParameter("rno"); // 후기 번호
		int rno = 0;
		try {
			rno = Integer.parseInt(rnoStr);
		}catch (Exception e) {
		}
		
		ReviewService service = new ReviewService();
		ReviewImageService service2 = new ReviewImageService();
		int result2 = service2.delete(rno);
		int result = service.delete(rno);
		
		System.out.println(result);
		out.println(result);
		out.flush();
		out.close(); 
		
	}

}
