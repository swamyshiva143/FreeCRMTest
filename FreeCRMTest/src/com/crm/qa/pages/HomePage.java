package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[@class='right menu']//span[text()='Swamyshiva  Akula']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactsLink;
	
	@FindBy(xpath="//button[@class='ui linkedin button']//i[@class='edit icon']")
	WebElement newContactsLink;
	
	
	@FindBy(xpath="//i[@class='calendar icon']")
	WebElement calendarLink;
	
	@FindBy(xpath="//i[@class='building icon']")
	WebElement companiesLink;
	
	@FindBy(xpath="//i[@class='money icon']")
	WebElement dealsLink;
	
	
	//Initializing the Page Objects;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitleTest() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	 public void clickOnNewContactsLink() {
		 Actions action= new Actions(driver);
		 action.moveToElement(contactsLink).build().perform();
		 newContactsLink.click();
	 }
	 
	public CalendarPage clickOnCalendarLink() {
		calendarLink.click();
		return new CalendarPage();
		
	}
	
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
		
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	
}
