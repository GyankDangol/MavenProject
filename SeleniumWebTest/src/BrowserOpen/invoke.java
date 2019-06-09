package BrowserOpen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;



public class invoke {
	
	public static void main(String[] args) {
		invoke obj =  new invoke();
		obj.invokeBrowser();
	}

	public void invokeBrowser() {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
		driver.get("https://facebook.com");
	}
	
}
