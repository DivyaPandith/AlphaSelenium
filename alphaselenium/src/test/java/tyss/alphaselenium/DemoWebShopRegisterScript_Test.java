package tyss.alphaselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoWebShopRegisterScript_Test {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void register() {
		driver.get("https://demowebshop.tricentis.com/register");
		DemoWebShopRegisterPom drp = new DemoWebShopRegisterPom(driver);
		drp.getFemaleGender().click();
		drp.getFirstName().sendKeys("Nalinakshi");
		drp.getLastName().sendKeys("Chikkaswamy");
		drp.getEmail().sendKeys("nalinakshi@gmail.com");
		drp.getPassword().sendKeys("chikkaswamy");
		drp.getConfirmPassword().sendKeys("chikkaswamy");
		drp.getRegisterButton().click();
		
		if (driver.getTitle().equals("Demo Web Shop. Register")) {
			Reporter.log("Your registration Completed",true);
		}
		
		
			
	}

}
