import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.TestUtil;

public class DataProviderTestNG {

	WebDriver driver ;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C://Users//DELL//Desktop//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
	ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
	return testData.iterator();
	
		
	}
	
	@Test (dataProvider="getTestData",priority=2)
	public void sinUp(String firstname ,String lastname,String mobileName,String password){
		driver.findElement(By.xpath(".//*[@id='u_0_l']")).sendKeys(firstname);
		driver.findElement(By.xpath(".//*[@id='u_0_n']")).sendKeys(lastname);
		driver.findElement(By.xpath(".//*[@id='u_0_q']")).sendKeys(mobileName);
		driver.findElement(By.xpath(".//*[@id='u_0_x']")).sendKeys(password);

		
	}
	
	/*@Test
	public void logout(){
		
	}*/
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
