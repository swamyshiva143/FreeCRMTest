package com.crm.qa.testdata;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	
	public ContactsPageTest() {
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

	 @Test(priority=3)
	 public void verifyContactsPageLabel() {
		 Assert.assertTrue(contactsPage.verifyContactsLabel());
	 }
	 
	 @Test(priority=4)
	 public void selectSingleContactsTest() {
		 contactsPage.selectContactsbyName("shiva king");
	 }
	 
	 @Test(priority=2)
	 public void selectMultipleContactsTest() {
		 contactsPage.selectContactsbyName("shiva king");
		 contactsPage.selectContactsbyName("swamy akula");
	 }
	 
	 @Test(priority=1)
	 public void validateCreateNewContact(String firstName, String lastName, String company) {
		 homePage.clickOnNewContactsLink();
		 contactsPage.createNewContact("SMS", "Hero", "Infosys");
	 }
	 
	 
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	 
	 
}
