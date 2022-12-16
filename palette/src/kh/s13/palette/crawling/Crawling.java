package kh.s13.palette.crawling;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kh.s13.palette.crawling.model.service.CrawlingService;
import kh.s13.palette.product.model.service.ProductService;
import kh.s13.palette.product.model.vo.ProductVo;

public class Crawling {

	private CrawlingService service = new CrawlingService();
	private ProductVo vo = new ProductVo();
	
	public static void main(String[] args) throws IOException {
		new Crawling().crawling();
	}
	
	public void crawling() throws IOException {
		
		String url = "https://www.poom.co.kr/dispctg/initArtboxCtg.action?disp_ctg_no=2008003291";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver drv = new ChromeDriver();   // 크롬창이 열림을 확인함.
		WebDriverWait wait = new WebDriverWait(drv, 10);
		JavascriptExecutor jexe = (JavascriptExecutor)drv;
		
		drv.get(url);  // 이동하고 싶은 url
		
		
		// 카테고리페이지에서 (뷰페이지에서) 추출할때 for문 돌리기
		//*[@id="goods_list"]/ul/li[1]/dl/dt/a[1]
		//*[@id="goods_list"]/ul/li[2]/dl/dt/a[1]
		//*[@id="goods_list"]/ul/li[5]/dl/dt/a[1]
		
		for (int i = 1; i <= 27; i++) {
			
//			ChromeOptions options = new ChromeOptions();
//	        options.addArguments("start-maximized");
//	        drv = new ChromeDriver(options);
		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"goods_list\"]/ul/li["+i+"]/dl/dt/a[1]"))).click();
	
			wait.until(ExpectedConditions.titleContains("POOM"));
		
		
			// 카테고리아이디 TODO
			int cid = 11;
			
			// 상품아이디
			WebElement pidEle = drv.findElement(By.xpath("//*[@id=\"conTab_0\"]/div[1]/dl/dd"));
			String pid = pidEle.getText();
			System.out.println(pid);
			
			// 상품명
			WebElement pnameEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[2]"));
			String pname = pnameEle.getText();
			System.out.println(pname);
			
			// 가격
			int pprice = 0;
			if (drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[3]/dl/dd/div")).getSize().width == 1) { // TODO
				WebElement ppriceEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[3]/dl/dd/div"));
			//*[@id="content"]/div/div[1]/div[2]/div[1]/div[3]/dl/dd/div 	--> 할인X
			//*[@id="content"]/div/div[1]/div[2]/div[1]/div[3]/dl/dd/div[2]	--> 할인O
				
				// 가격만 추출
				String[] ppriceArr = ppriceEle.getText().split(" ");
				String ppriceStr = ppriceArr[1]; 
				System.out.println(ppriceStr);
				try {
					pprice = Integer.parseInt(ppriceStr);
				} catch (Exception exp) {
				}
			} else {
				continue;
			}
			
			// 혜택
			WebElement pbenefitEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[1]/dd"));
			// 혜택만 추출
			String[] pbenefitArr = pbenefitEle.getText().split("\n");
			String pbenefit = pbenefitArr[0]; 
			System.out.println(pbenefit);
			
			// 배송비
			WebElement pdeliveryEle = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[2]/dd"));
			// 배송비만 추출
			String[] pdeliveryArr = pdeliveryEle.getText().split("\n");
			String pdelivery = pdeliveryArr[0]; 
			System.out.println(pdelivery);
			
			
			// 대표이미지1 
			WebElement pimg1UrlEle = drv.findElement(By.xpath("//*[@id=\"gd_pg\"]/ul/li[1]/a/img"));
			String pimg1Url = pimg1UrlEle.getAttribute("src");
			System.out.println(pimg1Url);
			String fileName1 = pid + "_1";
			// 이미지 저장
			service.getImageUrl(pimg1Url, fileName1);
			
			// 대표이미지2
			WebElement pimg2UrlEle = drv.findElement(By.xpath("//*[@id=\"gd_pg\"]/ul/li[1]/a/img"));
			String pimg2Url = pimg2UrlEle.getAttribute("src");
			System.out.println(pimg2Url);
			String fileName2 = pid + "_2";
			// 이미지 저장
			service.getImageUrl(pimg2Url, fileName2);
			
			
			// 상품 상세 (통 GOODS_HTML)
			WebElement pdetailEle = drv.findElement(By.xpath("//*[@id=\"html_div\"]"));
			//String pdetail = pdetailEle.getText(); -> 사용불가
			String pdetail = pdetailEle.getAttribute("innerHTML");
			System.out.println(pdetail);
			
			
//---------------------------------------------------------------------------------------------
			
			// product 테이블에 데이터 insert
			String pimage1 = "./resources/images/"+fileName1+".jpg";
			String pimage2 = "./resources/images/"+fileName2+".jpg";
			System.out.println(pimage1);
			System.out.println(pimage2);
			vo = new ProductVo(pid, cid, pname, pimage1, pimage2, 
					pprice, pbenefit, pdelivery, pdetail);
			service.insertProduct(vo);
		
		
			// 뒤로가기
			drv.navigate().back();
		}
		
		
		
		
		
		
		
		
		
		
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
		


		
	}
}
