package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	CalendarPage calendarPage;
	DealsPage dealsPage;
	CompaniesPage companiesPage;
	
	public HomePageTest() {
		super();
	}
	
	 @BeforeMethod
	 public void setUp() {
		 initialization();
		 loginPage= new LoginPage();
		 contactsPage= new ContactsPage();
		 calendarPage= new CalendarPage();
		 dealsPage= new DealsPage();
		 companiesPage = new CompaniesPage();
		 homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		 
	 }
	 
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitleTest();
		System.out.println("The title is:"+homePageTitle);
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "HomePage title is not matched");
	}
	
	@Test(priority=2)
	public void verifyContactsLink() {
		contactsPage= homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=3)
	public void verifyUsernameLabelTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=4)
	public void verifyCalendarLink() {
		calendarPage= homePage.clickOnCalendarLink();
	}
	
	@Test(priority=5)
	public void verifyCompaniesLink() {
		companiesPage= homePage.clickOnCompaniesLink();
	}
	
	@Test(priority=6)
	public void verifyDealsLink() {
		dealsPage= homePage.clickOnDealsLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
