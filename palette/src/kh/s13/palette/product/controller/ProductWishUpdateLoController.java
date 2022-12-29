package kh.s13.palette.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s13.palette.product.model.service.ProductWishService;
import kh.s13.palette.product.model.vo.ProductWishVo;

/**
 * Servlet implementation class ProductWishUpdateLoController
 */
@WebServlet("/product_wish_update.lo")
public class ProductWishUpdateLoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWishUpdateLoController() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String mid = request.getParameter("mid");
		String pid = request.getParameter("pid");
		String wish = request.getParameter("wish");
		System.out.println("mid : " + mid);
		System.out.println("pid : " + pid);
		System.out.println("wish : " + wish);
		
		ProductWishService service = new ProductWishService();
		
		int result = 0;
		if(wish.equals("no")) { // 찜 안한 상태에서 누름 (wish == "no" 라고 하면 안됨!! ==는 객체 자체가 같은지 비교하는거.. 문자열 비교는 equals) 
			result = service.insert(mid, pid);
		} else if (wish.equals("yes")) { // 찜 한 상태에서 누름
			result = service.delete(mid, pid);
		}
		
		System.out.println("result : " + result);
		out.println(result);
		out.flush();
		out.close(); 
	}

}
