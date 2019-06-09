package mouseAction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseActionFunction {
	static WebDriver driver;
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		driver.get("https://localfirstbank.com");

		

		selectPersonalMenu();
		scrollDown( driver);
		mouseAction();
		
	}
	
	
	public static void selectPersonalMenu() {
		WebElement personal= driver.findElement(By.xpath("//li[@id='menu-item-251']//a"));
		personal.click();
	}

	public static void scrollDown(WebDriver driver ) {
		JavascriptExecutor jse= ((JavascriptExecutor)driver);
		jse.executeScript("window.scrollTo(0,900)");
	}
	
	public static void mouseAction() {
		
		driver.findElement(By.id("helplink-selectSelectBoxItArrowContainer")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("helplink-selectSelectBoxItArrowContainer"))).build().perform();
		List <WebElement>itemlist=driver.findElements(By.xpath("//ul[@id='helplink-selectSelectBoxItOptions']//li"));
		int totalsize= itemlist.size();
		System.out.println(totalsize);
		
		for (int i = 0; i <totalsize; i++) {
			String dropDownlist= itemlist.get(i).getText();		
			System.out.println(dropDownlist);
			
			if (dropDownlist.contains("Banking options for students.")) {
				itemlist.get(i).click();
				
			}
		}
	}
}


		



