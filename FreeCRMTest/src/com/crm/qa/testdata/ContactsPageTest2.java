package com.crm.qa.testdata;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest2 extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="Contacts";


	
	public ContactsPageTest2() {
		super();
	}
	
	 @BeforeMethod
	 public void setUp() {
		 initialization();
		 loginPage= new LoginPage();
		 contactsPage= new ContactsPage();
		 homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		 contactsPage= homePage.clickOnContactsLink();
		
		 
	 }

 
	 
	 @Test(priority=1)
	 public void selectMultipleContactsTest() {
		 contactsPage.selectContactsbyName("shiva king");
		 contactsPage.selectContactsbyName("swamy akula");
	 }

	 @DataProvider
	 public Object[][] getCRMTestData(){
		 Object data[][]= TestUtil.getTestData(sheetName);
		 return data;
	 }
	 
	 @Test(priority=2)
	 public void validateCreateNewContact(String firstName, String lastName, String company) {
		 homePage.clickOnNewContactsLink();
		// contactsPage.createNewContact("SMS", "Hero", "Infosys");
		 contactsPage.createNewContact(firstName, lastName, company);
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
}
