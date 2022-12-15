package kh.s13.palette.crawling.model.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;

import kh.s13.palette.common.jdbc.JdbcTemplate;
import kh.s13.palette.crawling.model.dao.CrawlingDao;
import kh.s13.palette.product.model.vo.ProductVo;

public class CrawlingService {
	
	private CrawlingDao dao = new CrawlingDao();

	public int insertProduct(ProductVo vo) {
		System.out.println("CrawlingService insertProduct");
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		
		JdbcTemplate.setAutoCommit(conn, false); // 오토커밋 false로
		result = dao.insertProduct(conn, vo);
		System.out.println("dao에서 return한 result : " + result);
		
		if(result > 0) {
			JdbcTemplate.commit(conn); // 커밋성공시
			System.out.println("커밋성공");
		} else {
			JdbcTemplate.rollback(conn); // 커밋실패시 롤백
			System.out.println("커밋실패");
		}
		JdbcTemplate.close(conn); // 리턴하기 전에 닫아줌
		return result;
	}
	
	
	
	public void getImageUrl(String imageUrl, String fileName) throws IOException {
        URL url = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            url = new URL(imageUrl);
            in = url.openStream();

            // 컴퓨터 또는 서버의 저장할 경로(절대패스로 지정해 주세요.)
            out = new FileOutputStream("C:/z_workspace/java/palette/WebContent/resources/images/"+fileName+".jpg");

            while (true) {
                // 루프를 돌면서 이미지데이터를 읽어들이게 됩니다.
                int data = in.read();

                // 데이터값이 -1이면 루프를 종료하고 나오게 됩니다.
                if (data == -1) {
                    break;
                }

                // 읽어들인 이미지 데이터값을 컴퓨터 또는 서버공간에 저장하게 됩니다.
                out.write(data);
            }

            // 저장이 끝난후 사용한 객체는 클로즈를 해줍니다.
            in.close();
            out.close();

        } catch (Exception e) {
        	  // 예외처리
            e.printStackTrace();
        } finally {
            // 만일 에러가 발생해서 클로즈가 안됐을 가능성이 있기에
            // NULL값을 체크후 클로즈 처리를 합니다.
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
	}
}
