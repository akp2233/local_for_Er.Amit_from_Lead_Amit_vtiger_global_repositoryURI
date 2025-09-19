package com.crm.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver=null;

@FindBy(name="user_name")
private WebElement usernametextfield;

@FindBy(name="user_password")
private WebElement passwordtextfield;

@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
private WebElement loginbutton;

//give the initialization
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getusernametextfield() {
	return usernametextfield;
}

public WebElement getpasswordtextfield() {
	return passwordtextfield;
}

public WebElement getloginbutton() {
	return loginbutton;
}
public void logintoApp(String url,String username,String password) {
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	usernametextfield.clear();
	usernametextfield.sendKeys(username);
	passwordtextfield.clear();
	passwordtextfield.sendKeys(password);
	loginbutton.click();
}

}
