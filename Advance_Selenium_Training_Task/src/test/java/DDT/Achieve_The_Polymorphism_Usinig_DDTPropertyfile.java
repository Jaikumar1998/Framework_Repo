package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Achieve_The_Polymorphism_Usinig_DDTPropertyfile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\achievepolymorphismDDT.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String browser = pObj.getProperty("Browser");
		String url = pObj.getProperty("Url");
		String username = pObj.getProperty("Username");
		String password = pObj.getProperty("Password");
		
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title = 'Create Organization...']")).click();
		
		WebElement header =  driver.findElement(By.name("accountname"));
		header.sendKeys("jspider");
		String Header = header.getAttribute("value");
		System.out.println(Header);
		driver.findElement(By.name("website")).sendKeys("www.pysider.com");
		driver.findElement(By.name("email2")).sendKeys("jspider@gmail.com");
		
		WebElement element = driver.findElement(By.name("industry"));
		element.click();
		
		Select obj = new Select(element);
		obj.selectByVisibleText("Banking");
		
		WebElement element1 =driver.findElement(By.name("accounttype"));
		element1.click();
		
		Select obj1 = new Select(element1);
		obj1.selectByVisibleText("Investor");
		
		driver.findElement(By.xpath("(//input[@type = 'button'])[3]")).click();
		//driver.findElement(By.className("small")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.partialLinkText("Sign Out")).click();
		//driver.close();
		

	}

}
