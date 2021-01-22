package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
		
	}
	 @BeforeMethod
	 public void setUp() {
		 initialization();
		 loginPage= new LoginPage();
		 homePage= new HomePage();
	 }
	 
	 @Test(priority=2)
	 public void loginPageTitleTest() {
		 String title= loginPage.validateLoginPageTitle();
		 System.out.println(title);
		 Assert.assertEquals(title, "Cogmento CRM");
	 }
	 
	 
	 @Test(priority=1)
	 public void loginTest() {
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		 
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }

}
