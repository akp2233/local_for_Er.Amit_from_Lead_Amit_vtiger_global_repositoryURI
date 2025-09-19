package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ContactsInfoPage {
	WebDriver driver;
    @FindBy(xpath="//span[@class='dvHeaderText']")
     private WebElement headerText;
    public ContactsInfoPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
	public WebElement getHeaderText() {
		return headerText;
	}
    public void verifyContact(String firstName) {
    	Assert.assertTrue(headerText.getText().contains(firstName),"contacts is not created");
    	Reporter.log("contact is created",true);
    }
}
