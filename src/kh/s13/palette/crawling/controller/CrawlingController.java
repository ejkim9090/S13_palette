package kh.s13.palette.crawling.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import kh.s13.palette.crawling.model.service.CrawlingService;
import kh.s13.palette.product.model.service.ProductService;
import kh.s13.palette.product.model.vo.ProductVo;

/**
 * Servlet implementation class CrawlingController
 */
@WebServlet("/CrawlingController")
public class CrawlingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CrawlingService service = new CrawlingService();
	private ProductVo vo = new ProductVo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrawlingController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "https://www.poom.co.kr/goods/initDetailGoods.action?goods_no=G22080478355&sale_shop_divi_cd=11&sale_shop_no=&sale_area_no=&tr_yn=Y&conts_form_cd=100&conts_dist_no=G22080478355&conts_divi_cd=20&rel_no=G22080478355&rel_divi_cd=10&openwinyn=&disp_ctg_no=2008003292&purch_age_limit_cd=00&eval_tab_yn=&target=_self";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver drv = new ChromeDriver();   // 크롬창이 열림을 확인함.
		WebDriverWait w = new WebDriverWait(drv, 10);
		JavascriptExecutor jexe = (JavascriptExecutor)drv;
		
		drv.get(url);  // 이동하고 싶은 url
		

		
		// 카테고리아이디 TODO
		
		
		
		// 상품아이디
		WebElement pidEle = drv.findElement(By.xpath("//*[@id=\"conTab_0\"]/div[1]/dl/dd"));
		String pid = pidEle.getText();
		System.out.println(pid);
		
		// 상품명
		WebElement pnameEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[2]"));
		String pname = pnameEle.getText();
		System.out.println(pname);
		
		// 가격
		WebElement ppriceEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[3]/dl/dd/div"));
		String pprice = ppriceEle.getText();
		System.out.println(pprice);
		
		// 혜택
		WebElement pbenefitEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[1]/dd"));
		String pbenefit = pbenefitEle.getText();
		System.out.println(pbenefit);
		
		// 배송비
		WebElement pdeliveryEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[2]/dd"));
		String pdelivery = pdeliveryEle.getText();
		System.out.println(pdelivery);
		
		
		// 대표이미지1 
//		WebElement pimg1Ele = drv.findElement(By.xpath("//*[@id=\"gd_pg\"]/ul/li[1]/a/img"));
//		String pimg1 = pimg1Ele.getText();
//		System.out.println(pimg1);
		WebElement pimg1UrlEle = drv.findElement(By.xpath("//*[@id=\"gd_pg\"]/ul/li[1]/a/img"));
		String pimg1Url = pimg1UrlEle.getAttribute("innerHTML");
		System.out.println(pimg1Url);
		String fileName1 = pid + "_1";
		service.getImageUrl(pimg1Url, fileName1);
		
		// 대표이미지2
//		WebElement pimg2Ele = drv.findElement(By.xpath("//*[@id=\"gd_pg\"]/ul/li[2]/a/img"));
//		String pimg2 = pimg2Ele.getText();
//		System.out.println(pimg2);
		WebElement pimg2UrlEle = drv.findElement(By.xpath("//*[@id=\"gd_pg\"]/ul/li[2]/a/img"));
		String pimg2Url = pimg2UrlEle.getAttribute("innerHTML");
		System.out.println(pimg2Url);
		String fileName2 = pid + "_2";
		service.getImageUrl(pimg2Url, fileName2);

		
		
		// 상품 상세 (통 GOODS_HTML)
		WebElement productdetailEle = drv.findElement(By.xpath("//*[@id=\"html_div\"]"));
		//String productdetail = productdetailEle.getText(); -> 사용불가
		String productdetail = productdetailEle.getAttribute("innerHTML");
		System.out.println(productdetail);
		
		
		
		// product 테이블에 데이터 insert
		int cid = 11; // 카테고리아이디
		String pimage1 = "./images/class/"+fileName1+".jpg"; // TODO
		String pimage2 = "./images/class/"+fileName2+".jpg"; // TODO
//		vo = new ProductVo(pid, cid, pname, pimage1, pimage2, 
//				pprice, pbenefit, pdelivery, productdetail, reviewlist);
		
		
		
		
		
		
//		String ppriceStr = b.getText();
//		System.out.println(ppriceStr);
//		int pprice = 0;
//		try {
//			pprice = Integer.parseInt(ppriceStr);
//		}catch (Exception exp) {
//		}
//		String pBenefit = c.getText();
//		System.out.println(pBenefit);
//		String pDelivery = d.getText();
//		System.out.println(pDelivery);		
		
		
//		ProductVo vo = new ProductVo();
//		ProductService service = new ProductService();
//		vo.setPname(pname);
//		vo.setPprice(pprice);
//		service.insert(vo);
		

		// 카테고리페이지에서 (뷰페이지에서) 추출할때 for문 돌리기
		//*[@id="goods_list"]/ul/li[1]/dl/dt/a[1]
		//*[@id="goods_list"]/ul/li[2]/dl/dt/a[1]
		//*[@id="goods_list"]/ul/li[5]/dl/dt/a[1]
		
	}



}
