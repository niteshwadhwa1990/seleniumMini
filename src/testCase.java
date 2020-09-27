import org.testng.annotations.Test;

import utility.Utility;

//import CodeTest2.functions;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class testCase {
	
  @Test
  public void f() throws Exception {
	 // public WebDriver driver;
		 constants c = new constants();
		System.setProperty("webdriver.chrome.driver", c.chromeDriverPath);
		System.setProperty("webdriver.gecko.driver", c.firefoxDriverPath);
	  WebDriver driver;
	 
		functions f = new functions();
		//functions f = new functions();
		//readExcelData red = new readExcelData();
		FileInputStream fs = new FileInputStream("C:\\Users\\Nitesh Wadhwa\\Desktop\\Nitesh\\Selenium Java\\demoFile.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		for(int i=1; i<rowCount; i++) {
			if(i%2==0) {
				 driver = new ChromeDriver();
			}
			else {
				driver = new FirefoxDriver();
			}
		f.openBrowser(driver);
		Utility.takescreenshot(driver, "step :: Open Browser and Enter URL");
		//utility.Utility.takescreenshot(driver, "step :: Open Browser and Enter URL");
		String email = sheet.getRow(i).getCell(0).toString();
		System.out.println(email);
		f.enterEmail(driver, email);
		utility.Utility.takescreenshot(driver, "step :: Enter Unique Email"+i);
		String firstName = sheet.getRow(i).getCell(1).toString();
		String lastName = sheet.getRow(i).getCell(2).toString();
		String password = sheet.getRow(i).getCell(3).toString();
		String address = sheet.getRow(i).getCell(4).toString();
		String city = sheet.getRow(i).getCell(5).toString();
		String postcode = "35211";
		String phoneNumber = "8237068857";
		f.populateFields(driver, firstName, lastName, password, address, city, postcode, phoneNumber);
		utility.Utility.takescreenshot(driver, "step :: Populate mandatory fields and register");
		f.verification(driver);
		utility.Utility.takescreenshot(driver, "step :: Submit fileds verify");
		f.logoutAndClose(driver);
		utility.Utility.takescreenshot(driver, "step :: Close browser");
		}
		
		
	}

  //@BeforeMethod
  //public void beforeMethod() {
	//  System.out.println("Staring the test case");
  //}

  //@AfterMethod
 // public void afterMethod() {
//	  System.out.println("Ending the test case");
  //}

}
