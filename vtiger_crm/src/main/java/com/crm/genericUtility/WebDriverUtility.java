package com.crm.genericUtility;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * @author dk
	 * this method is used to set the implicitly time in test script
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	 /**
	  * @author dk
	  * this method is work as a explicit wait it is wait for expected condition if condition is satisfy then control goes to next line 
	  * @param driver
	  * @param element
	  */
	 public void waitForElementPresent(WebDriver driver,WebElement element) {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	 }
	 /**
	  * @author dk
	  * this method is used to switch window with the help of  url contains String
	  * @param driver
	  * @param expectURL
	  */
	 public void switchToTabOnUrl(WebDriver driver,String expectURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(expectURL)) {
				break;
			}
			
		}
	 }
	 /**
	  * @author dk
	  * this method is used to switch the window based upon Title
	  * @param driver
	  * @param partailTitle
	  */
	 public void switchToTabOnTitle(WebDriver driver,String partailTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String windowid = it.next();
				driver.switchTo().window(windowid);
				String actTitle = driver.getTitle();
				if(actTitle.contains(partailTitle)) {
					break;
				}
				
			}
	 }
	 /**
	  * @author dk
	  * this methods is used switch to frame in three way by index,by id/name or webElement 
	  * here we achieved method overloading concept
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver,int index) {
		 driver.switchTo().frame(index);
	 }
	 public void switchToFrame(WebDriver driver,String nameID) {
		 driver.switchTo().frame(nameID);
	 }
	 public void switchToFrame(WebDriver driver,WebElement element) {
		 driver.switchTo().frame(element);
	 }
	 /**
	  * @author dk
	  * this method is used to handle alert popup 
	  * here we derive separate methods for accept,dismiss ,get text,send data from popup
	  * @param driver
	  */
	 public void switchToAlertAndAccept(WebDriver driver) {
		 driver.switchTo().alert().accept();
	 }
	 public void switchToAlertAndCancel(WebDriver driver) {
		 driver.switchTo().alert().dismiss();
	 }
	 public String switchToAlertAndFetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	 }
	 public void switchToAlertAndsendText(WebDriver driver,String text) {
			 driver.switchTo().alert().sendKeys(text);
			
		 }
	 
	 /**
	  * @author dk 
	  * this method is used to select the data from dropDown by index,value ,visible text
	  * @param element
	  * @param index
	  */
	 public void selectDataDropDownByIndex(WebElement element,int index) {
		 Select sel=new Select(element);
		 sel.selectByIndex(index);
	 }
	 public void selectDataDropDownByValue(WebElement element,String value) {
		 Select sel=new Select(element);
		 sel.selectByValue(value);
	 }
	 public void selectDataDropDownByVisibleText(WebElement element,String text) {
		 Select sel=new Select(element);
		 sel.selectByVisibleText(text);;
	 }
	 /**
	  * @author dk
	  * this method is used to return the all the option present inside the dropdown 
	  * here we use collection concept because we want to return the multiple value 
	  * first we create list generic <String> we store String type object thats type collection and use the reference and call add method add all the 
	  * @param element
	  * @return list<String> because its return set of  String values 
	  */
	public List<String> getAllDataFromDropdown(WebElement element ) {
		Select sel=new Select(element);
		List<WebElement> alloption = sel.getOptions();
		List<String>allData=new ArrayList<>();
		
		for(WebElement el:alloption) {
			allData.add(el.getText());//use add method to add element /data inside the list
		}
		return allData;
	}
	//here we create Actions class method
	/**
	 * @author dk 
	 * this methods are used for mouse related operation in our test script
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions ac=new Actions(driver);
		ac.scrollToElement(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement sources,WebElement target ) {
		Actions ac=new Actions(driver);
		ac.dragAndDrop(sources, target).perform();
	}
	public void rightclickOnElement(WebDriver driver,WebElement element) {
		Actions ac=new Actions(driver);
		ac.contextClick(element).perform();
	}
	public void clickAndHold(WebDriver driver,WebElement element) {
		Actions ac=new Actions(driver);
		ac.clickAndHold(element).perform();
	}
	public void dubleClickOnElement(WebDriver driver,WebElement element) {
		Actions ac=new Actions(driver);
		ac.doubleClick(element).perform();
	}
	
	
	 

}
