package mouseAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseTomove {

	static WebDriver driver;

	public static void main(String[] args) {
		invokeBrowser();
		//mouseAction();
		clickOnSignIn();
	}

	public static void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gyand\\eclipse-workspace\\SeleniumWebTest\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://spicejet.com");

	}
	public static void mouseAction()  {
		Actions actionOfMouse= new Actions(driver);
		WebElement addonsmenu= driver.findElement(By.xpath("//li[@id='header-addons']"));
		actionOfMouse.moveToElement(addonsmenu).build().perform();
		List<WebElement> element=driver.findElements(By.xpath("//ul[@class='add-ons-tab']//li"));

		for (int i = 0; i <element.size(); i++) {
			String listofele=element.get(i).getText();
			System.out.println(listofele);

			if (listofele.contains("Travel Insurance")) {
				element.get(i).click();
				break;
			}

		}

		//Thread.sleep(3000);
		driver.navigate().back();

	}
	public static  void clickOnSignIn() {
		Actions act= new Actions(driver);
		WebElement singInMenu= driver.findElement(By.xpath("//div[@id='smoothmenu1']//a[@class='link']"));
		act.moveToElement(singInMenu).build().perform();

		List<WebElement>listOfSingIn=driver.findElements(By.xpath("//div[@id='smoothmenu1']//li[14]//ul//li"));
		int sizeOfSignIN= listOfSingIn.size();
		System.out.println(sizeOfSignIN);

		for (int i = 0; i < listOfSingIn.size(); i++) {
			String text =listOfSingIn.get(i).getText();
			System.out.println(text);

			if (text.contains("SpiceClub Members")) {
				listOfSingIn.get(i).click();
			
			}
		}

		driver.findElement(By.linkText("Sign up")).click();
		driver.navigate().back();

	}
}