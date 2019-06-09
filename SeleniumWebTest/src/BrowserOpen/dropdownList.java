package BrowserOpen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownList {
	static  WebDriver driver;
	static WebElement day,month,year;
	
	
	public static void main(String[] args) {
	
		invokeBrowser();
		DropDownFromList();

		selectValueFromDropDown(day,"20" );
		selectValueFromDropDown(month, "Oct");
		selectValueFromDropDown(year, "1982");
	}

	
	//This block of code open the FaceBook HomePage
	public  static void invokeBrowser() {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
		driver.get("https://facebook.com");	



	}
	
	//This block of code is used find WebElements 
	public static void DropDownFromList() {
		day = driver.findElement(By.id("day"));
		month= driver.findElement(By.id("month"));
		year = driver.findElement(By.id("year"));

		//		Select select = new Select(day);
		//		select.selectByVisibleText("10");
		//
		//		Select select1 = new Select(month);
		//		select1.selectByVisibleText("Oct");
		//
		//		Select select2 = new Select(year);
		//		select2.selectByVisibleText("1992");;

	}

	// This block of code is used to call WebElement
	public  static void selectValueFromDropDown(WebElement element,String value) {

		Select select =new Select(element);
		select.selectByVisibleText(value);
	}


}