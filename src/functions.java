import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class functions extends testCase {
	// private static WebDriver driver;
	 static constants c = new constants();

	   
	public static void openBrowser(WebDriver driver) {
	
		
		driver.get(c.testURL);
		driver.manage().window().maximize();
	}
public static void enterEmail(WebDriver driver, String email) {
	driver.findElement(By.linkText(c.signInLinkText)).click();
	driver.findElement(By.xpath(c.emailXpath)).sendKeys(email);
	//("077z0zzzzzzzzzzzzemailAddress001@newemail.com")
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(c.emailXpath)).sendKeys(Keys.ENTER);
	//driver.findElement(By.xpath(c.createAccountButton)).click();
	//driver.findElement(By.className("icon-user left")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
}
public static void populateFields(WebDriver driver, String firstName, String lastName, String password, String address, String city, String postcode, String number) {
	
	driver.findElement(By.id(c.firstNameField)).sendKeys(firstName);
	driver.findElement(By.id(c.lastNameField)).sendKeys(lastName);
	driver.findElement(By.id(c.passwordField)).sendKeys(password);
	driver.findElement(By.xpath("//*[@for='id_gender1']")).click();
	driver.findElement(By.id(c.addressField)).sendKeys(address);
	driver.findElement(By.id(c.cityField)).sendKeys(city);
	driver.findElement(By.id(c.stateField)).click();
	driver.findElement(By.xpath(c.stateType)).click();
	driver.findElement(By.id(c.postcode)).sendKeys(postcode);
	driver.findElement(By.id(c.phoneNumber)).sendKeys(number);
	driver.findElement(By.id(c.submitButton)).click();
	//System.out.println("Complete");
}

public static void verification(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String name = driver.findElement(By.xpath(c.accountName)).getText();
	System.out.println(name);
	String fullName = c.firstName + " " + c.lastName;
	if(driver.findElement(By.className(c.myAccountHeader)).isDisplayed()) 
	{System.out.println("Correct");}
	else {System.out.println("Incorrect");}
	
	if(name.contentEquals(fullName))
	{System.out.println("Correct");}
	else {System.out.println("Incorrect");}
}

public static void logoutAndClose(WebDriver driver) {

	driver.findElement(By.className(c.logoutButton)).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.close();
}
}
