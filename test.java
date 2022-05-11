import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class test {


	  public static void sleep(int time) {
	    try {
	      Thread.sleep(time);
	    } catch (InterruptedException e) {
	      System.out.println("********Unable to wait *******************");
	    } 
	  }
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\quality\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		//login_Page
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
		driver.findElement(By.id("login-button")).click();
		sleep(3000);

		
		//Home_Page	
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_list']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='title']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed());
		sleep(3000);
		
		//LogOut
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).isDisplayed());
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		
		sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).isDisplayed());
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
		
		if(driver.findElement(By.id("login-button")).isDisplayed()) {
			System.out.println("Test Passed");
			driver.close();  //Kill Chrome
			System.out.println("Chrome Closed");
		}		
	}

}
