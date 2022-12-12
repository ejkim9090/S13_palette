package kh.s13.palette.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		Post 인 경우 encoding 방식 지정해 줘야 한글 깨짐 방지
//		get은 url 통해서 데이터가 전달되는 방식으로 이미 utf-8 로 encoding 되어서 따로 설정 setter 하지 않아도 됨.
		request.setCharacterEncoding("UTF-8");
		
//		contentType="text/html; charset=UTF-8"
		response.setContentType("text/html; charset=UTF-8");

		chain.doFilter(request, response);
	}

}
