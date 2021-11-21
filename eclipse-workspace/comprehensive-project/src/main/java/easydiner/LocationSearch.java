package easydiner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocationSearch {
	@Test
	public void locatinSearch() {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

//navigating to url
		driver.get("https://www.eazydiner.com/delhi-ncr?loc=connaught-place-central-delhi");
//selecting a location
		driver.findElement(By.xpath("//*[@id=\"srchbar\"]")).click();
		driver.findElement(By.xpath("//*[@data-city=\"Chennai\"]")).click();
//searching for restaurants 
		driver.findElement(By.xpath("//span[text()=\"Search\"]")).click();
		String s = driver.findElement(By.xpath("//*[@class=\"font-18 grey semi-bold\"]")).getText();
//verification
		Assert.assertEquals("Chennai Restaurants", s);
		System.out.println(s);
		driver.close();
	}
}
