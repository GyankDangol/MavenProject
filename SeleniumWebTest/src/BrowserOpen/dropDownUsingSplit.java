package BrowserOpen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownUsingSplit {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\geckodriver\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get("https://facebook.com");
		
		WebElement month= driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.id("day"));
		WebElement year= driver.findElement(By.id("year"));
	
		String dateOfBirth = "Oct-10-1982";
		String dob[] = dateOfBirth.split("-");
		
		
		selectValueFromDropDown(month,dob[0]);
		selectValueFromDropDown(day, dob[1]);
		selectValueFromDropDown(year, dob[2]);
	
		
	}

	public static void selectValueFromDropDown(WebElement element, String value) {
		
		Select select = new Select(element);
		select.selectByVisibleText(value);
		}
	

}
