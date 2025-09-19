package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver=null;
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgbutton;
	
	@FindBy(name="accountname")
	private WebElement orgNameTetField;
	
	@FindBy(name="website")
	private WebElement websiteTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutton;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgbutton() {
		return createOrgbutton;
	}

	public WebElement getOrgNameTetField() {
		return orgNameTetField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	public void createOrganization(String orgname,String website) {
		createOrgbutton.click();
		orgNameTetField.sendKeys(orgname);
		websiteTextField.sendKeys(website);
		savebutton.click();	
	}
	public void createOrganizationWithIndustry(String orgname,String website,String industryname) {
		createOrgbutton.click();
		orgNameTetField.sendKeys(orgname);
		websiteTextField.sendKeys(website);
		
		Select sl=new Select(industryDropDown);
		sl.selectByValue(industryname);
		savebutton.click();	
	}
}
