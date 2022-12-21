package kh.s13.palette.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.member.model.vo.MemberVo;
import kh.s13.palette.product.model.service.ProductWishService;
import kh.s13.palette.product.model.vo.ProductWishVo;

/**
 * Servlet implementation class MypageWishController
 */
@WebServlet("/mypage/wish")
public class MypageWishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageWishController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 찜한 상품 목록
		String mid = ((MemberVo)request.getSession().getAttribute("loginSsInfo")).getMid();
		
		ProductWishService service = new ProductWishService();
		List<ProductWishVo> volist = service.selectList(mid);
	
		request.setAttribute("wishlist", volist); // wishlist라는 String에 volist를 대입해줌 -> jsp파일에서 volist를 호출하기 위해 aaa 사용 가능

		String viewPath = "/WEB-INF/view/mypage_wish.jsp";
		request.getRequestDispatcher(viewPath).forward(request, response);// 이부분만 계속 바꿔서 사용하면됨. 여기엔 <%=request.getContextPath()%> 작성 안함 (forward방식은 애초에 contextpath가 유지가 됨)
	}

}
