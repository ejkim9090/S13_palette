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
import kh.s13.palette.product.model.vo.MyProductWishVo;
import kh.s13.palette.product.model.vo.ProductDetailVo;
import kh.s13.palette.product.model.vo.ProductVo;
import kh.s13.palette.product.model.vo.ProductWishVo;
import kh.s13.palette.review.model.service.ReviewImageService;
import kh.s13.palette.review.model.service.ReviewLikeService;
import kh.s13.palette.review.model.service.ReviewService;
import kh.s13.palette.review.model.vo.ProductReviewVo;
import kh.s13.palette.review.model.vo.ReviewImageVo;
import kh.s13.palette.review.model.vo.ReviewLikeVo;
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 상품상세페이지
		String pid = request.getParameter("pid");
		
		String mid = "";
//		try {
//			mid = ((MemberVo)request.getSession().getAttribute("loginSsInfo")).getMid();
//		}catch(Exception e) {
//		}
		mid = "user1"; // 테스트용
		
		// 나의 찜 상태
		ProductWishService wishService = new ProductWishService();
		ProductWishVo wishVo = wishService.selectOne(mid, pid);
		
		// 상품 한 개 정보
		ProductService productService = new ProductService();
		ProductDetailVo productVo = productService.selectOne(pid);
		
		// 후기 사진 더보기
		ReviewImageService rimageService = new ReviewImageService();
		List<ReviewImageVo> rimagelist = rimageService.selectList(pid);
		
		// 나의 후기 좋아요 상태
		String rnoStr = request.getParameter("rno");
		int rno = 0;
		if(rnoStr != null) {
			try {
				rno = Integer.parseInt(rnoStr);
			} catch (Exception e) {}
		}
		ReviewLikeService likeService = new ReviewLikeService();
		ReviewLikeVo likeVo = likeService.selectOne(rno, mid);
		
		// 후기 목록
		ReviewService reviewService = new ReviewService();

		// <내가 정하는 고정개수>
		final int pageSize = 10; // 페이지당 글 수
		
		// <DB에서 불러와야하는 수>
		int cnt = 0; // 총 글 수
		int pageCnt = 0; // 총 페이지 수
		int currentPage = 1; // 현재페이지. 기본 1. 눌리면 바뀜
				
		try {
			cnt = reviewService.selectPTotalCnt(pid); // 상품 후기 총 개수
			
			if(cnt < 1) { // 후기 없는 경우. -> 아래 후기 selectList 할 필요 없음.
				return;
			}
			try {
				currentPage = Integer.parseInt(request.getParameter("pagenum"));
			} catch (Exception e) {
			}
			pageCnt = (cnt/pageSize) + (cnt%pageSize==0 ? 0 : 1); // 총 페이지 수

			int startRnum = (currentPage - 1) * pageSize + 1; // 해당 페이지의 시작 글 번호
			int endRnum = startRnum + pageSize - 1; // 해당 페이지의 마지막 글 번호
			if(endRnum > cnt ) {
				endRnum = cnt;
			}
			
			List<ProductReviewVo> reviewlist = reviewService.selectPList(pid, startRnum, endRnum);
			request.setAttribute("reviewlist", reviewlist);
			
		} finally { // finally문은 무조건 거치게됨

			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("currentPage", currentPage);
			
			request.setAttribute("reviewCnt", cnt);
			
			request.setAttribute("mid", mid);
			if(wishVo != null) {
				request.setAttribute("wish", "yes");
			}else {
				request.setAttribute("wish", "no");
			}
			request.setAttribute("product", productVo);
			request.setAttribute("rimagelist", rimagelist);
			if(likeVo != null) {
				request.setAttribute("like", "yes");
			}else {
				request.setAttribute("like", "no");
			}
			
			String viewPath = "/WEB-INF/view/product.jsp";
			request.getRequestDispatcher(viewPath).forward(request, response);
		}
		
	}


}
