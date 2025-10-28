package pkg1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Orangehrm {
	public static WebDriver driver;
	@Test
	public void openurl() {
		driver=new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	@Test(dependsOnMethods= {"openurl"},priority=2)
	public void enteridNpass() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	@Test(dependsOnMethods= {"enteridNpass"},priority=3)
	public void submit() {
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
}
