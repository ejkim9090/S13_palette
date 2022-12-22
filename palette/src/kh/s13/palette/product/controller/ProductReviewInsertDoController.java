package kh.s13.palette.product.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import kh.s13.palette.member.model.vo.MemberVo;
import kh.s13.palette.review.model.service.ReviewService;
import kh.s13.palette.review.model.vo.ReviewVo;

/**
 * Servlet implementation class ProductReviewInsertDoController
 */
@WebServlet("/product/review/insert.do")
public class ProductReviewInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductReviewInsertDoController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rnoStr = request.getParameter("rno");
		int rno = 0;
		try {
			rno = Integer.parseInt(rnoStr);
		} catch (Exception e) {
		}
		String pid = request.getParameter("pid");

		// 로그인이 안되어있을때 후기 작성하려 한다면, 로그인 후 하도록 유도
		MemberVo loginSsInfo = (MemberVo) request.getSession().getAttribute("loginSsInfo");
		String mid = null;

		if (loginSsInfo == null) { // 로그인 안한 상태
			response.sendRedirect(request.getContextPath() + "/login");
			return; // 밑의 코드 수행 안하게끔
		} else { // 로그인 한 상태
			mid = loginSsInfo.getMid();
		}
		String rcontent = request.getParameter("rcontent");

		// 사진 업로드 설정
		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String fileSavePath = "upload";
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10 * 1024 * 1024;
		String encType = "UTF-8";

		// enctype="multipart/form-data" 로 전송되었는지 확인
		if (!ServletFileUpload.isMultipartContent(request))
			response.sendRedirect("view/error/Error.jsp");

		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		MultipartRequest multi = new MultipartRequest(request, // request 객체
				uploadPath, // 서버 상 업로드 될 디렉토리
				uploadSizeLimit, // 업로드 파일 크기 제한
				encType, // 인코딩 방법
				new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
		);
		Enumeration files = multi.getFileNames();
		while (files.hasMoreElements()) {
			// 업로드 된 파일 이름 얻어오기
			String file = (String) files.nextElement();
			String fileName = multi.getFilesystemName(file);
		}
		
		
		
		ReviewService service = new ReviewService();
		ReviewVo vo = new ReviewVo();
		vo.setRno(rno);
		vo.setPid(pid);
		vo.setMid(mid);
		vo.setRcontent(rcontent);
		vo.setRimagelist(rimagelist);

		
		
		int result = service.insert(vo);

		if (result > 0) { // 작성 성공시

			request.setAttribute("func", "reviewInsert");
			request.setAttribute("msg", "후기 등록에 성공했습니다.");
			request.getRequestDispatcher("/WEB-INF/view/resultAlert.jsp").forward(request, response);

		} else { // 작성 실패시

			request.setAttribute("func", "reviewInsert");
			request.setAttribute("msg", "후기 등록에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/view/resultAlert.jsp").forward(request, response);
		}
	}

}
