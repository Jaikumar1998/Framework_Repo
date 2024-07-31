package package2;

import org.testng.annotations.Test;

public class orgTest {
	
	@Test
	public void createOrgTest() {
		System.out.println("Execution of createorgTest");
	}

	@Test
	public void modifyOrgTest() {
		System.out.println("Execution of modify OrgTest");
		String Url = System.getProperty("url");
		String Browser = System.getProperty("browser");
		
		System.out.println(Url);
		System.out.println(Browser);
	}
	
	@Test
	public void deleteOrgTest() {
		System.out.println("Execution of delete OrgTest");
	}
}
