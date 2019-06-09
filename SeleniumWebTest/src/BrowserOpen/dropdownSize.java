package BrowserOpen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownSize {

	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\geckodriver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get("https://facebook.com");

		//WebElement month= driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.id("day"));
		WebElement year= driver.findElement(By.id("year"));

		Select select2 = new Select(year);
		List<WebElement> listofyear = select2.getOptions();
		System.out.println(listofyear.size());
		int totalyear = listofyear.size()-1;
		System.out.println("Total year is  "+totalyear);
		
		
		Select select = new Select(day);
		System.out.println(select.isMultiple());
		List<WebElement> listofday=select.getOptions();
		System.out.println(listofday.size());
		int totalday= listofday.size()-1;
		System.out.println("Total days in month is"+totalday);
		
		
		for (int i = 0; i < listofday.size(); i++) {
			String daysValues =listofday.get(i).getText();
			System.out.println("value of days is "+daysValues);
			
			if (daysValues.equalsIgnoreCase("20")) {
				listofday.get(i).click();
				break;
				
			}
			
		}




	}
}





