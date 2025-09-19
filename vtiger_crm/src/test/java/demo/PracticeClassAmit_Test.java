package demo;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeClassAmit_Test {
@Test
public void parcticAmitDemo() {
WebDriver driver =new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("http://amazon.com");
@Nullable
String expTitle = driver.getTitle();
Assert.assertEquals(driver.getTitle(), expTitle,"parcticAmitDemo is faild");
Reporter.log("test case is pass====parcticAmitDemo");

}
}
