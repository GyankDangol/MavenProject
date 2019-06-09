package BrowserOpen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdownWithoutSelect {
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
		String year_xpath = "//select[@id='year']//option";

		selectValueFromDropDown(month_xpath, "Jul");
		selectValueFromDropDown(day_xpath, "10");
		selectValueFromDropDown(year_xpath, "2019");

	}

	public static void selectValueFromDropDown(String xpath_value, String value) {
		List<WebElement>listofmonth= driver.findElements(By.xpath(xpath_value));
		System.out.println(listofmonth.size());


		for (int i = 0; i <listofmonth.size(); i++) {

			String monthvalue= listofmonth.get(i).getText();
			System.out.println(monthvalue);
			if (listofmonth.get(i).getText().equals(value)) {
				listofmonth.get(i).click();

			}
		}

	}

}
