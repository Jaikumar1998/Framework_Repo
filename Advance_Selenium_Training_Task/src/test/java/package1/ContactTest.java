package package1;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test
	public void createContactTest() {
		System.out.println("Execution of creatContactTest");
		String Url = System.getProperty("url");
		String Browser = System.getProperty("browser");
		
		System.out.println(Url);
		System.out.println(Browser);
	}
	
	@Test
	public void modifyContactTest() {
		System.out.println("Execution of modifyContactTest");
	}

}
