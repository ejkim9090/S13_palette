package kh.s13.palette.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.member.model.vo.MemberVo;
import kh.s13.palette.product.model.service.ProductService;
import kh.s13.palette.product.model.service.ProductWishService;
import kh.s13.palette.product.model.vo.ProductDetailVo;
import kh.s13.palette.product.model.vo.ProductVo;
import kh.s13.palette.product.model.vo.ProductWishVo;
import kh.s13.palette.review.model.service.ReviewImageService;
import kh.s13.palette.review.model.service.ReviewService;
import kh.s13.palette.review.model.vo.ProductReviewVo;
import kh.s13.palette.review.model.vo.ReviewImageVo;
import kh.s13.palette.review.model.vo.ReviewVo;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상품상세페이지
		String pid = request.getParameter("pid");
		
		// 찜 여부 TODO
		String mid = "";
		try {
			mid = ((MemberVo)request.getSession().getAttribute("loginSsInfo")).getMid();
		}catch(Exception e) {
		}
		ProductWishService service = new ProductWishService();
		ProductWishVo vo = service.selectOne(mid, pid);
		
		// 상품 한 개 정보
		ProductService service2 = new ProductService();
		ProductDetailVo productVo = service2.selectOne(pid);
		
		// 후기 목록
		ReviewService service3 = new ReviewService();
		List<ProductReviewVo> reviewlist = service3.selectPList(pid);
		
		// 후기 사진
		ReviewImageService service4 = new ReviewImageService();
		List<ReviewImageVo> rimagelist = service4.selectList(pid);
	
		
		
		
		if(vo != null) {
			request.setAttribute("wish", "yes");
		}else {
			request.setAttribute("wish", null);
		}
		request.setAttribute("product", productVo);
		request.setAttribute("reviewlist", reviewlist);
		request.setAttribute("rimagelist", rimagelist);
		
		String viewPath = "/WEB-INF/view/product.jsp";
		request.getRequestDispatcher(viewPath).forward(request, response);
	}


}
