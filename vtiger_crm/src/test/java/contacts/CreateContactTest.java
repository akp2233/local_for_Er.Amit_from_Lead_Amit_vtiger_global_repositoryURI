package contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.ExcelUtility;
import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.HomePage;

public class CreateContactTest extends BaseClass {
	ExcelUtility elib=new ExcelUtility();
	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		//fetching the data from excel file used business method
		String firstname=elib.getDataFromExcelFile("contacts", 1, 0);
		String lastname=elib.getDataFromExcelFile("contacts", 1, 1);
		String deptname=elib.getDataFromExcelFile("contacts", 1, 2);
		String email=elib.getDataFromExcelFile("contacts", 1, 3);
		//navigate to contacts page
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		//Create the Object of Create ContactsPage then enter all the details to create new contacts
		CreateContactsPage ccp=new CreateContactsPage(driver);
		//try to fail the scripts here
		ccp.createContactsWithEmails(firstname, lastname, deptname, email);
		
		//verify the header created or not but create business method inside pom page no need to do hardcode here
//		String headerText=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		Assert.assertTrue(headerText.contains(firstname),"contacts is not created");
//		Reporter.log("suhan kumar : contacts is created ");
		ContactsInfoPage cinfop=new ContactsInfoPage(driver);
		cinfop.verifyContact(firstname);
	}
		
	}


