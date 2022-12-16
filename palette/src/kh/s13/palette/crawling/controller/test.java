package kh.s13.palette.crawling.controller;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver drv = new ChromeDriver();   // 크롬창이 열림을 확인함.
		WebDriverWait w = new WebDriverWait(drv, 10);
		JavascriptExecutor jexe = (JavascriptExecutor)drv;
		
		drv.get("https://www.iei.or.kr/login/login.kh");  // 이동하고 싶은 url
		WebElement e1 = drv.findElement(By.id("id"));
		WebElement e2 = drv.findElement(By.id("password"));
		
		e1.sendKeys("cksun2599");
		e2.sendKeys("lucy7328*");
		
		jexe.executeScript("fnLogin()");
		w.until(ExpectedConditions.titleContains("수강생 평가"));
		jexe.executeScript("location.href='/login/currBoard.kh'");

//		drv.close();  // 크롬창 닫기 하면 화면이 확 닫히므로 일단 주석처리
	}

}
