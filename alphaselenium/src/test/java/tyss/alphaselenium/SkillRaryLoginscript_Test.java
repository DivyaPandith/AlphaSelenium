package tyss.alphaselenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SkillRaryLoginscript_Test {

	WebDriver driver;
	String url,email,password;

	@Test
	public void dataReciever() throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./test-data/login.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
		
	url = wb.getSheet("Sheet1").getRow(3).getCell(0).getStringCellValue();
	email=wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
	password=wb.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue();
	}

	@Test
	public void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();


		driver.navigate().to(url);

		SkillRaryLoginPom sp = new SkillRaryLoginPom(driver);
		driver.findElement(By.id("loginClick")).click();
		sp.getEmailTF().sendKeys(email);
		sp.getPasswordTF().sendKeys(password);
		sp.getLoginButton().click();


	}

}
