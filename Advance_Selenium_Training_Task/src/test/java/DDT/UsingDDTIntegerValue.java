package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingDDTIntegerValue {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\fbdata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("Url");
		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"));{
			driver = new ChromeDriver();
			
		}
		
		
		
		//From in this scenario we can also access integer value as a string
		
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		
	
		driver.close();
		
		
		

	}

}
