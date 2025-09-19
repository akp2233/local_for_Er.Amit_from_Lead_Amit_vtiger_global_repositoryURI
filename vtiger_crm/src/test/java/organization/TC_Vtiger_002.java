package organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.genericUtility.ExcelUtility;

public class TC_Vtiger_002 {
@Test
public void fetchAllDataFromExcelUseingUserDefineMethod() throws EncryptedDocumentException, IOException {
	ExcelUtility exutil=new ExcelUtility();
	System.out.println(exutil.getMultipleDataFromExcel("org"));
}
}
