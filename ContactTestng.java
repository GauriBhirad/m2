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

public class ContactTestng extends BaseClass{
	
	PropertyFileUtil putil=new PropertyFileUtil();
	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
	
	WebDriver d;
	
	@Test
	public void contactsTest() throws IOException, InterruptedException
	{
//		WebDriver d=new ChromeDriver();
//		wutil.maximize(d);
//		wutil.implicitWait(d);
//		
//		//To read data from Property File
//		String URL = putil.getDataFromPropertyFile("Url");
//	    String USERNAME = putil.getDataFromPropertyFile("Username");
//	    String PASSWORD = putil.getDataFromPropertyFile("Password");
	    
	    
//	    //To launch the url
//	   	d.get(URL);  
//	 	//To Enter useraname and password
//	  	d.findElement(By.name("user_name")).sendKeys(USERNAME);
//	  	d.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	  	//Click on Login
//	  	d.findElement(By.id("submitButton")).click();
//	  	
	  	
	  	//Click on Contact
	  	d.findElement(By.xpath("//a[text()='Contacts']")).click();
	  	
	  	//Click on Create Contact (+)
	  	d.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
	  	
	     //To read data from excel
	  	 String firstNm = eutil.getDataFromExcel("Contacts", 0, 1);
		 String lastNm = eutil.getDataFromExcel("Contacts", 1, 1);
		 String team = eutil.getDataFromExcel("Contacts", 2, 1);
		 String orgName = eutil.getDataFromExcel("Contacts", 3, 1);
	  	
	  	//Enter First name
	    d.findElement(By.name("firstname")).sendKeys(firstNm);
	    
	    d.findElement(By.name("lastname")).sendKeys(lastNm);
	    
	    
//	    To fail the testscript
//	    String actualUrl = d.getCurrentUrl();
//	    String expectedUrl="http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
//	    Assert.assertEquals(actualUrl, expectedUrl);
	    
	    
	    
	    //to click on "group" of "Assigned To" element
	    d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	    
	    //DropDown select
	    WebElement dropDown = d.findElement(By.name("assigned_group_id"));
	    wutil.handleDropDown(dropDown, team);  
	    
	    
	    d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	    
	    //Transfer the driver control from parent window to child window
	    wutil.switchwindow(d, "localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
	    
	    
	    //Enter the Organization name
	    d.findElement(By.id("search_txt")).sendKeys(orgName);
	    //Click on search button
	    d.findElement(By.name("search")).click();
	    
	    //Click on Organisation name i.e(Qspiders)
	    d.findElement(By.xpath("//a[text()='Qspiders']")).click();
	    
	    //Transfer the driver control from child window to parent window
	    wutil.switchwindow(d, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
	   
	    //Click on save button
	    d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	    
//	    Thread.sleep(2000);
//		 //MouseHover on image to signout
//		 WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//		 wutil.mouseHover(d, image);
//	    
//	    //Click on signout
//		 d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    
	    
	}


}
