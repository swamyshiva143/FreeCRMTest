package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage2 extends TestBase{
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactsLink;
	
	@FindBy(xpath="//button[@class='ui linkedin button']//i[@class='edit icon']")
	WebElement newContactsLink;
	
	//Initializing the Page OBjects
	 public HomePage2() {
		 PageFactory.initElements(driver, this);
		 
	 }

	 public void clickOnNewContactsLink() {
		 Actions action= new Actions(driver);
		 action.moveToElement(contactsLink).build().perform();
		 newContactsLink.click();
	 }
}
