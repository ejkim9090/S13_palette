package kh.s13.palette.crawling.controller;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test2 {

	public static void main(String[] args) throws IOException {

		String url = "https://www.poom.co.kr/goods/initDetailGoods.action?goods_no=G22080478355&sale_shop_divi_cd=11&sale_shop_no=&sale_area_no=&tr_yn=Y&conts_form_cd=100&conts_dist_no=G22080478355&conts_divi_cd=20&rel_no=G22080478355&rel_divi_cd=10&openwinyn=&disp_ctg_no=2008003292&purch_age_limit_cd=00&eval_tab_yn=&target=_self";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver drv = new ChromeDriver();   // 크롬창이 열림을 확인함.
		WebDriverWait w = new WebDriverWait(drv, 10);
		JavascriptExecutor jexe = (JavascriptExecutor)drv;
		
		drv.get(url);  // 이동하고 싶은 url
		
		WebElement a = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[2]"));
//		WebElement b = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[3]/dl/dd/div/span/text()"));
		WebElement b = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[1]/div[3]/dl/dd/div"));
//		WebElement c = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[1]/dd/text()"));
		WebElement c = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[1]/dd"));
//		WebElement d = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[2]/dd/text()"));
		WebElement d = drv.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[2]/div[2]/dl[2]/dd"));
		WebElement e = drv.findElement(By.xpath("//*[@id=\"conTab_0\"]/div[1]/dl/dd"));
		WebElement imgEle = drv.findElement(By.xpath("//*[@id=\"gd_img\"]/img"));
		
		String pName = a.getText();
		System.out.println(pName);
		String pPrice = b.getText();
		System.out.println(pPrice);
		String pBenefit = c.getText();
		System.out.println(pBenefit);
		String pDelivery = d.getText();
		System.out.println(pDelivery);
		String pId = e.getText();
		System.out.println(pId);
		
		// 통 GOODS_HTML
		WebElement goodshtmlEle = drv.findElement(By.xpath("//*[@id=\"html_div\"]"));
		//String goodshtml = goodshtmlEle.getText();
		String goodshtml = goodshtmlEle.getAttribute("innerHTML");
		System.out.println(goodshtml);
		
		
		
//		jexe.executeScript("fnLogin()");
//		w.until(ExpectedConditions.titleContains("수강생 평가"));
//		jexe.executeScript("location.href='/login/currBoard.kh'");

//		drv.close();  // 크롬창 닫기 하면 화면이 확 닫히므로 일단 주석처리
	}

}
