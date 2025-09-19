package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingExcel_FinalTest {

    @Test(dataProvider = "getdata")
    public void getProductInfo(String productName, int rowIndex)
            throws IOException, EncryptedDocumentException {

        // load URL from properties
        FileInputStream fisf = new FileInputStream("./src/test/resources/testdata/flipkart.properties");
        Properties pro = new Properties();
        pro.load(fisf);
        String url = pro.getProperty("url");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("🔍 Searching for: " + productName);

        // search product
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.clear();
        searchBox.sendKeys(productName, Keys.ENTER);

        // wait until product list loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='_30jeq3'])[1]")));

        // get the price of the FIRST element in search results
        WebElement firstPrice = driver.findElement(By.xpath("(//div[@class='_30jeq3'])[1]"));
        String productPrice = firstPrice.getText();
        System.out.println("💰 Captured price for " + productName + " = " + productPrice);

        // write price back into Excel
        FileInputStream fis = new FileInputStream("./src/test/resources/testdata/Book1.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet("Flipkart");
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(2); // write in 3rd column
        cell.setCellValue(productPrice);

        FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata/Book1.xlsx");
        wb.write(fos);
        wb.close();

        driver.quit();
    }

    @DataProvider
    public Object[][] getdata() throws EncryptedDocumentException, IOException {
        FileInputStream fis = new FileInputStream("./src/test/resources/testdata/Book1.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet("Flipkart");
        int rowcount = sheet.getLastRowNum();

        Object[][] objarr = new Object[rowcount][2];
        for (int i = 0; i < rowcount; i++) {
            Row row = sheet.getRow(i + 1);
            objarr[i][0] = row.getCell(0).toString(); // product name
            objarr[i][1] = i + 1; // row index
        }
        wb.close();
        return objarr;
    }
}
