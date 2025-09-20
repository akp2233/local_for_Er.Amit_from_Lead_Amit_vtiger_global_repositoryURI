package contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.ExcelUtility;
import com.crm.objectRepository.ContactsInfoPage;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.HomePage;

public class CreateContactsWithPhoneNumber_Test extends BaseClass {
	@Test
	public void createContactsWithPhonenumber() throws EncryptedDocumentException, IOException {
		ExcelUtility elib=new ExcelUtility();
		String firstName = elib.getDataFromExcelFile("Contacts", 2, 0);
		System.out.println("Hi");
		String lastName = elib.getDataFromExcelFile("Contacts", 2, 1);
		String deptname = elib.getDataFromExcelFile("Contacts", 2, 2);
		String phoneNumber = elib.getDataFromExcelFile("Contacts", 2, 4);
		//navigate to Contacts page
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		//click in to create new contacts link which is present in side CreateContact page
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.createContactsWithPhoneNumber(firstName, lastName, deptname, phoneNumber);
		ContactsInfoPage cinfop=new ContactsInfoPage(driver);
		cinfop.verifyContact(firstName);
	}

}
