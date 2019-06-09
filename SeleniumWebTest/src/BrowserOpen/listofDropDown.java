package BrowserOpen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class listofDropDown {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.get("https://www.facebook.com");
		
		String month_xpath = "//select[@id='month']//option";
		String day_xpath = "//select[@id='day']//option";
		String year_xpath ="//select[@id='year']//option";
		
		
		
		
		selectValueFromDropDown(month_xpath,"Jun");
		selectValueFromDropDown(day_xpath,"13");
		selectValueFromDropDown(year_xpath,"1980");
		
		
	}

	public static void selectValueFromDropDown(String xpathvalue, String value) {
		List<WebElement>monthlist =driver.findElements(By.xpath(xpathvalue));
		System.out.println( monthlist.size());

		for (int i = 0; i<monthlist.size(); i++) {
			String monthvalue= monthlist.get(i).getText();
			System.out.println(monthvalue);

			if (monthlist.get(i).getText().equals(value)) {
				monthlist.get(i).click();
				break;
			}

		}
	}
}