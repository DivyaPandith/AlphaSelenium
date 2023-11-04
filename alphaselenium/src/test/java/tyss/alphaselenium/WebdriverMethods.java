package tyss.alphaselenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class WebdriverMethods {

	public static void main(String[] args) throws InterruptedException, IOException {

// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));

//	Navigate to Url using get()Method

		driver.get("https://shoppersstack.com/products_page/6");

// Capture the current url using getCurrentUrl() Method
		String url = driver.getCurrentUrl();
		System.out.println(url);

// Capture title of the page using getTitle()Method
		String title = driver.getTitle();
		if (title.equals("ShoppersStack | Product Description")) {
			System.out.println("navigated to product page:	" + title);
		}

		driver.findElement(By.id("compare")).click();

//	Capture window ids using getWindowhandle() and getWindowHandles()Methods
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			driver.switchTo().window(id);
			System.out.println(driver.getCurrentUrl() + ":     " + id);
			
//getSize() ans setSize() of the windows	
			System.out.println(driver.manage().window().getSize().height);
			driver.manage().window().setSize(new Dimension(545,343));
			
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		
		LocalDateTime time = LocalDateTime.now();
		String actualTime = time.toString().replace(":","_");
		
		File dest = new File("./screenshots/"+ actualTime +".png");
		FileHandler.copy(temp, dest);
			
			Thread.sleep(2000);
			
// Close the current window
			driver.close();
			
		}

	}

}
