package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static WebDriver d;
	PropertyFileUtil putil=new PropertyFileUtil();
	WebDriverUtil wutil=new WebDriverUtil();
	@BeforeSuite
	public void BS() {
		System.out.println("Before connecting to database");
	}
	
	@BeforeClass
    public void BC() throws IOException {
		
		//To read data from Property File
		String URL = putil.getDataFromPropertyFile("Url");
				
		WebDriver d=new ChromeDriver();
		//To maximize the window
		wutil.maximize(d);
		//to apply wait to findelement()
		wutil.implicitWait(d);
		
		//To launch the url
		d.get(URL); 
		
	}
	@BeforeMethod
	public void BM() throws IOException {
		//@BeforeMethod is used to login to the application
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//To Enter useraname and password
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//Click on Login
		d.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		Thread.sleep(2000);
		//@AfterMethod is used to signout from the application
		//MouseHover on image to signout
		 WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 wutil.mouseHover(d, image);
		 
		 //Click on signout
		 d.findElement(By.xpath("//a[text()='Sign Out']")).click();

		
	}
	
	@AfterClass
    public void AC() {
		//@AfterClass is used to close the browser
		d.quit();
		
	}
	@AfterSuite
	public void AS() {
		System.out.println("After connected to database");
		
	}
	

}
