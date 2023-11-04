package tyss.alphaselenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoWebShopLoginScript_Test {

	WebDriver driver;
	String Url,Email,Password;
	
@Test
public void dataReciever() throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./test-data/login.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
	Url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	Email= wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	Password = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	
}
@Test
public void login() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(Url);
	
	DemoWebShopLoginPom dlp = new DemoWebShopLoginPom(driver);
	dlp.getEmail().sendKeys(Email);
	dlp.getPassword().sendKeys(Password);
	dlp.getLoginButton().click();
	
	if (driver.getTitle().equals("Demo Web Shop")) {
		Reporter.log("logged in successfully",true);
	}
	else
	{
		Reporter.log("couldnot log in",true);
     }
}
}
