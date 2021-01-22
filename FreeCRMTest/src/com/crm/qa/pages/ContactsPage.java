package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	
	//initializing the page objects:
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsbyName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
		
	}
	
	public void createNewContact(String ftName, String ltName, String comp) {
		
			firstName.sendKeys(ftName);
			lastName.sendKeys(ltName);
			company.sendKeys(comp);
			saveBtn.click();
	}

	}
	
	
	
	
	
	
