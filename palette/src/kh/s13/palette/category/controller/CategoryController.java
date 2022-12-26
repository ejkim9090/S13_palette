package kh.s13.palette.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.product.model.service.CategoryService;
import kh.s13.palette.product.model.service.ProductService;
import kh.s13.palette.product.model.vo.CategoryProductVo;
import kh.s13.palette.product.model.vo.CategoryVo;
import kh.s13.palette.product.model.vo.ProductVo;


/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클릭한 카테고리의 상품만 보이게
		String cidStr = request.getParameter("cid");
		int cid = 0;
		if(cidStr != null) {
			try {
				cid = Integer.parseInt(cidStr);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
System.out.println("### cid: " + cid);
		// 배송옵션
		String pdelivery = request.getParameter("pdelivery");
		// 가격옵션
		String startpriceStr = request.getParameter("startprice");
		String endpriceStr = request.getParameter("endprice");
System.out.println("### pdelivery: " + pdelivery);
System.out.println("### startpriceStr: " + startpriceStr);
System.out.println("### endpriceStr: " + endpriceStr);
		int startprice = 0;
		int endprice = 0;
		if(startpriceStr != null && endpriceStr != null) {
			try {
				startprice = Integer.parseInt(startpriceStr);
				endprice = Integer.parseInt(endpriceStr);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 낮은가격순/높은가격순 정렬
		// TODO
		
		ProductService service = new ProductService();
		CategoryService service2 = new CategoryService();
		
		List<CategoryProductVo> volist = service.selectList(cid, pdelivery, startprice, endprice);
		System.out.println(volist);
		
		int cpid = cid/10 * 10; // 대분류아이디
		///대분류 명을 읽어와서 setAttribute
		request.setAttribute("cpid", cpid);
		List<CategoryVo> volist2 = service2.selectList(cpid);
		System.out.println(volist2);
		
		
//		if(pdelivery != null && !pdelivery.equals("")) {
//			request.setAttribute("pdelivery", pdelivery);
//		}
//		if(startprice != 0 && endprice != 0) {
//			request.setAttribute("startprice", startprice);
//			request.setAttribute("endprice", endprice);
//		}
		request.setAttribute("productlist", volist);
		if(volist2 != null)
			request.setAttribute("categorylist", volist2);
		
		String viewPath = "/WEB-INF/view/category.jsp";
		request.getRequestDispatcher(viewPath).forward(request, response);
	}



}
