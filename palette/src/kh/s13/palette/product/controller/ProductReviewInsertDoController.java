package kh.s13.palette.product.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.s13.palette.member.model.vo.MemberVo;
import kh.s13.palette.review.model.service.ReviewImageService;
import kh.s13.palette.review.model.service.ReviewService;
import kh.s13.palette.review.model.vo.ReviewImageVo;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ReviewService service = new ReviewService();
		ReviewImageService service2 = new ReviewImageService();

		
		String pid = request.getParameter("pid");
		// 로그인이 안되어있을때 후기 작성하려 한다면, 로그인 후 하도록 유도
		MemberVo loginSsInfo = (MemberVo) request.getSession().getAttribute("loginSsInfo");
		String mid;
		if (loginSsInfo == null) { // 로그인 안한 상태
			response.sendRedirect(request.getContextPath() + "/login");
			return; // 밑의 코드 수행 안하게끔
		} else { // 로그인 한 상태
			mid = loginSsInfo.getMid();
		}
		String rcontent = "";
		List<String> rfilepathlist = new ArrayList<String>(); 
		

		// 사진 업로드 설정
		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		String saveFolder = "/resources/review"; //저장하고 싶은 폴더
		String path = request.getServletContext().getRealPath(saveFolder);
		System.out.println(path);

		int size = 10 * 1024 * 1024; // 크기 지정 값
		DiskFileItemFactory factory = new DiskFileItemFactory(); //업로드 된 파일을 저장할 저장소와 관련 클래스
		File currentDir = new File(path);
		factory.setRepository(currentDir); //File 객체로 지정한 업로드된 파일을 저장할 위치
		factory.setSizeThreshold(size); //임시파일을 생성할 한계 크기 지정
		
		ServletFileUpload upload = new ServletFileUpload(factory); //  'multipart/form-data '형식으로 넘어온 데이터를 다루기 쉽게 변환
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item : items) {
				if(item.isFormField()) { //해당 값이 true면 text같은 일반 데이터, false면 파일데이터
					String all = item.getFieldName() + " = " + item.getString("utf-8"); //name = value, getString 시 인코딩해줘야함.
					System.out.println(all);
					String name = item.getFieldName(); //name = value, getString 시 인코딩해줘야함.
					String value = item.getString("utf-8"); //name = value, getString 시 인코딩해줘야함.
					switch(name) {
					case "pid" : pid = value; break;
					case "rcontent" : rcontent = value.replaceAll("\n", "%%"); System.out.println("줄변환 리뷰내용 :"+rcontent); break;
					}
				}
				else { // 파일데이터인 경우
					System.out.println(item.getFieldName());

					String separator = File.separator; //운영체제별로 다른 파일경로 구분자 추출
					int index = item.getName().lastIndexOf(separator); //업로드한 파일 경로의 마지막 separator 뒤에오는 값이 실제 파일명
					String origin = item.getName().substring(index+1);
					System.out.println("origin :"+origin);
					if(origin.equals("")) {
						System.out.println("첨부파일 없음");
					} else {
						String ext = origin.substring(origin.lastIndexOf("."));
						
						//이름 중복을 방지하기 위한 처리
						UUID uuid = UUID.randomUUID();
						String name = uuid + ext;
						
						System.out.println("파일 이름 :" + name); //저장되는 이름 확인
						rfilepathlist.add("/resources/review/" + name); //저장되는 이미지들 경로 값 추가
						
						System.out.println(item.getSize()); //파일 크기 확인
						if(!currentDir.exists()) { //저장할 경로 폴더가 있는건지 확인
							currentDir.mkdirs(); //없으면 해당 경로 폴더들 다 생성
						}
						
						File uploadFile = new File(currentDir+separator+name); //저장할 파일 생성
						item.write(uploadFile); //첨부파일을 해당 경로로 저장
					}
				}
			}
			//받아온 값 insert
			ReviewVo vo = new ReviewVo();
			vo.setPid(pid);
			vo.setMid(mid);
			vo.setRcontent(rcontent);
			
			System.out.println("사진 리스트 크기 : "+rfilepathlist.size());
			
			int result = service.insert(vo, rfilepathlist); // 여기서 이미지도 함께 저장
			System.out.println("저장될 리뷰:" +vo.toString());
			
			if (result > 0) { // 작성 성공시
				request.setAttribute("func", "reviewInsert");
				request.setAttribute("msg", "후기 등록에 성공했습니다.");
				request.setAttribute("pid", pid);
				request.getRequestDispatcher("/WEB-INF/view/resultAlert.jsp").forward(request, response);
				
			} else { // 작성 실패시
				request.setAttribute("func", "reviewInsert");
				request.setAttribute("msg", "후기 등록에 실패했습니다.");
				request.setAttribute("pid", pid);
				request.getRequestDispatcher("/WEB-INF/view/resultAlert.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("후기 등록 중 오류 발생");
		}
		
		
		

		
		
		
		
		
		// COS 라이브러리 사용시 - multiple 안됨
		// enctype="multipart/form-data" 로 전송되었는지 확인
//		if (!ServletFileUpload.isMultipartContent(request))
//			response.sendRedirect("view/error/Error.jsp");
//
//		MultipartRequest multi = new MultipartRequest(request, // request 객체
//				path, // 서버 상 업로드 될 디렉토리 (인코딩타입=multipart형식으로 parsing해서 file 형태인 것을 file 형태로 이곳에 저장)
//				10 * 1024 * 1024, // 업로드 파일 크기 제한 (10MB)
//				"UTF-8", // 인코딩 방법 (file 이외의 데이터 인코딩 방식)
//				new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
//		); // 여기서 file 저장 완료
//		System.out.println("########## 1");
//		System.out.println(multi.getFilesystemName("uploadFile"));
//		Enumeration<?> files = multi.getFileNames();
//		while (files.hasMoreElements()) {
//			// 업로드 된 파일 이름 얻어오기 (동일 이름 존재 시 바뀌어진 이름)
//			String file = (String) files.nextElement();
//			String fileName = multi.getFilesystemName(file);
//			System.out.println("########## 2");
//			System.out.println(file);
//			System.out.println(fileName);
//			String dbFilePath = saveFolder +"/"+ fileName;
//		}
	}

}
