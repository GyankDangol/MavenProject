package BrowserOpen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bustrapDropDown {
	
	static WebDriver driver;
	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.get("https://localfirstbank.com");

	

		WebElement personal= driver.findElement(By.xpath("//li[@id='menu-item-251']//a"));
		personal.click();
		WebElement pleaseSelectto=driver.findElement(By.xpath("//span[@id='helplink-selectSelectBoxItArrowContainer']//i"));
		pleaseSelectto.click();
		
		drowborder(pleaseSelectto,driver);
		scrollDown( driver);
		clickOnDropdownItem();
	
	}

	public static void drowborder(WebElement element, WebDriver driver ) {
		JavascriptExecutor jsc=((JavascriptExecutor)driver);
		jsc.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void scrollDown(WebDriver driver ) {
		JavascriptExecutor jse= ((JavascriptExecutor)driver);
		jse.executeScript("window.scrollTo(0,900)");
	}


	public static void clickOnDropdownItem() {
		List <WebElement> itemstudent= driver.findElements(By.xpath("//ul[@id='helplink-selectSelectBoxItOptions']//li"));
		System.out.println( itemstudent.size());

		for (int i = 0; i < itemstudent.size(); i++) {
			String itemvalue = itemstudent.get(i).getText();
			System.out.println(itemvalue);
			boolean bitem =itemstudent.get(i).isDisplayed();
			System.out.println(bitem);
			
			
			if (itemvalue.contains("Banking that gives me perks and pays me interest.")){
				itemstudent.get(i).click();
			}
			
		}
	}
}