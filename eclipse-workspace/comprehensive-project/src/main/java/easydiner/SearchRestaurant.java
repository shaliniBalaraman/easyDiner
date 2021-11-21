package easydiner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchRestaurant {
	@Test
	public void RestaurantSearch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.eazydiner.com/delhi-ncr?loc=connaught-place-central-delhi");


		driver.findElement(By.xpath("//*[@id=\"home-search\"]")).sendKeys("Bombay Brasserie" + Keys.ENTER);

		Thread.sleep(300);
		WebElement element = driver.findElement(By.xpath("//span[text()='Search']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		String s = driver.findElement(By.xpath("//h2[@class='font-20 bold grey']")).getText();
//verification
		Assert.assertEquals("Bombay Brasserie", s);
		System.out.println(s);
		driver.close();
	}
}
