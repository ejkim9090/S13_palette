package kh.s13.palette.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.product.model.service.ProductService;
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
			}
		}
		if(cid == 0) {
			String viewPath = "/WEB-INF/view/error.jsp";
			request.getRequestDispatcher(viewPath).forward(request, response);
			return;
		}
		
		ProductService service = new ProductService();
		List<ProductVo> volist = service.selectList(cid);
		
		request.setAttribute("current_cid", cid);
		request.setAttribute("productList", volist);
		
		String viewPath = "/WEB-INF/view/category.jsp";
		request.getRequestDispatcher(viewPath).forward(request, response);
	}



}
