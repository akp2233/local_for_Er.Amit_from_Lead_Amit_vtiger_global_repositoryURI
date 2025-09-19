package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
	WebDriver driver;
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactsButton;
	
	@FindBy(name="firstname")
	private WebElement firtnameTextField;
	
	@FindBy(name="lastname")
	private WebElement lastnameTextField;
	
	@FindBy(name="department")
	private WebElement departmentTextField;
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(name="assistantphone")
	private WebElement phonenumbertextField;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	public CreateContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactsButton() {
		return createContactsButton;
	}

	public WebElement getFirtnameTextField() {
		return firtnameTextField;
	}

	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getDepartmentTextField() {
		return departmentTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPhonenumbertextField() {
		return phonenumbertextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public void createContactsWithEmails(String firstName,String lastName,String deptName,String email) {
		createContactsButton.click();
		firtnameTextField.sendKeys(firstName);
		lastnameTextField.sendKeys(lastName);
		departmentTextField.sendKeys(deptName);
		emailTextField.sendKeys(email);
		saveButton.click();
		
	}
	public void createContactsWithPhoneNumber(String firstName,String lastName,String deptName,String phoneNumber) {
		createContactsButton.click();
		firtnameTextField.sendKeys(firstName);
		lastnameTextField.sendKeys(lastName);
		departmentTextField.sendKeys(deptName);
		phonenumbertextField.sendKeys(phoneNumber);
		saveButton.click();
		
	}
}
