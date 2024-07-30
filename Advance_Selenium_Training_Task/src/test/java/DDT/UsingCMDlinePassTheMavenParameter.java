package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UsingCMDlinePassTheMavenParameter {
	
	/**
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test
	public void demoWebShop() throws EncryptedDocumentException, IOException {
		
		String Browser = System.getProperty("browser");
		String Url = System.getProperty("url");
		String  MailId = System.getProperty("mailid");
		String Password = System.getProperty("password");
		
		FileInputStream fis = new FileInputStream("‪C:\\Users\\HP\\OneDrive\\DemoWebShop.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		String productName=sh.getRow(1).getCell(1).toString();
		wb.close();
		
		WebDriver driver= null;
		
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(Url);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(MailId);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		driver.findElement(By.id("small-searchterms")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
	}

}
