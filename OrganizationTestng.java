package VtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class OrganizationTestng extends BaseClass {
	
	public WebDriver d;
	PropertyFileUtil putil=new PropertyFileUtil();
	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
	
	@Test
	public void OrganizationTest() throws IOException, InterruptedException
	{
//		WebDriver d=new ChromeDriver();
//		//To maximize the window
//		wutil.maximize(d);
//		//to apply wait to findelement()
//		wutil.implicitWait(d);
		
//		d.manage().window().maximize();
//		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//To read data from Property File
//		String URL = putil.getDataFromPropertyFile("Url");
//		String USERNAME = putil.getDataFromPropertyFile("Username");
//		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//To read data from excel file
		String orgName = eutil.getDataFromExcel("Organisations", 0, 1);
		String group = eutil.getDataFromExcel("Organisations", 1, 1);
		
		
		
		//To launch the url
//		d.get(URL);  
//		//To Enter useraname and password
//		d.findElement(By.name("user_name")).sendKeys(USERNAME);
//		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		//Click on Login
//		d.findElement(By.id("submitButton")).click();
		
		
		
		//Click on Organisation
		d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//Click on Create Organization (+)
		d.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//click on account name and type "Qspiders"
		//Random methos is created in javautil class to run the class multiple times.
		d.findElement(By.cssSelector("input[name='accountname']")).sendKeys(orgName+jutil.getRandomNumber());
		
		//In Assigned to click on group
		//Click on Assigned radio button
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
//		
		//In the dropdown Select support group
//		//click on dropdown
		 WebElement dropDown = d.findElement(By.name("assigned_group_id"));
		 wutil.handleDropDown(dropDown, group);
		 
		 //Click on save button
		 d.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		 
		 //To takescreenshot
		 wutil.screenShot(d, "Organization");
		 
//		 Thread.sleep(2000);
//		 //MouseHover on image to signout
//		 WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//		 wutil.mouseHover(d, image);
//		 
//		 //Click on signout
//		 d.findElement(By.xpath("//a[text()='Sign Out']")).click();

			
	}

}
