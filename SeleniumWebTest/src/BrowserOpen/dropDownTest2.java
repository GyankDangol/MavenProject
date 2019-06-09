package BrowserOpen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dropDownTest2 {
	
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\geckodriver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get("https://facebook.com");

	
		List<WebElement>monthlist= driver.findElements(By.xpath("//select[@id='month']//option"));
		List<WebElement>daylist=driver.findElements(By.xpath("//select[@id='day']//option"));
		List<WebElement>yearlist=driver.findElements(By.xpath("//select[@id='year']//option"));
		
		
		
		for (int i = 0; i <monthlist.size(); i++) {
			String monthval= monthlist.get(i).getText();
			System.out.println(monthval);
			if (monthlist.get(i).getText().equals("Jan")) {
				monthlist.get(i).click();
				
			}
			
		}
		for (int i = 0; i < daylist.size(); i++) {
			String dayvalue= daylist.get(i).getText();
			System.out.println(dayvalue);
			if (daylist.get(i).getText().equals("13")) {
				daylist.get(i).click();
			}
			
		}
		for (int i = 0; i <yearlist.size(); i++) {
			String yearvalue=yearlist.get(i).getText();
			System.out.println(yearvalue);
			if (yearlist.get(i).getText().equals("1982")) {
				yearlist.get(i).click();
			}
			
		}
		

	}
}


