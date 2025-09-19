package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver=null;
@FindBy(xpath="//a[text()='Organizations']")
private WebElement orglink;

@FindBy(xpath="//a[text()='Contacts']")
private WebElement contactlink;

@FindBy(linkText="Sign Out")
private WebElement signoutbutton;

@FindBy(xpath="//td[@class='genHeaderSmall']/following-sibling::td//img[contains(@src,'user')]")
private WebElement usersignout;

public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public WebElement getOrglink() {
	return orglink;
}

public WebElement getContactlink() {
	return contactlink;
}

public WebElement getUsersignout() {
	return usersignout;
}

//create business method for logout
public void signout() {
	Actions ac=new Actions(driver);
	ac.moveToElement(usersignout).perform();
	signoutbutton.click();
	
}
}



