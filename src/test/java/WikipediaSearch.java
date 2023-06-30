import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.Thread;


public class WikipediaSearch {

	@Test
	void verifyWikipediaPage() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.wikipedia.org/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("searchInput")).sendKeys("France");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	
	String expected_text = "Celtic Gauls";

	String pageContent = driver.findElement(By.tagName("body")).getText();     // Get the page content
	

	Assert.assertTrue(pageContent.contains(expected_text));       //Check if the string exists on the page

	System.out.println("Test passed!!");
	
	driver.quit();
	}
	

}