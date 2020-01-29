import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookFlight extends BookFlightHelper {
	
	 
	 	 
	 static final String chromeDriverLoc = System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe";
	 static WebDriver driver; 
	 static String url;
	 static final String excelLoc = System.getProperty("user.dir")+"/src/test/resources/testdata.xlsx";
	 
	 
	 @DataProvider(name = "myData")
	  public Object[][] dataSupplier() throws IOException, EncryptedDocumentException, InvalidFormatException {
		 
		 Object[][] obj = getExcelData(excelLoc);return  obj;
	  }

	 
	 /**
	     * This  method used to initiate browser with URL read from property file     
		 * @throws IOException *
	     */
	    
	    @BeforeMethod
	    public void setup() throws IOException
	    {
	    	Properties prop = new Properties();
			prop.load(new FileInputStream("src/test/resources/config.properties"));
			
	     	 System.setProperty("webdriver.chrome.driver",chromeDriverLoc);        
	    	 driver=new ChromeDriver();  
	    	 driver.navigate().to(prop.getProperty("url"));
	         driver.manage().window().maximize();
	    	           	          
	    }
	    
	    @AfterMethod   
	    public void afterTest () {   	
	    	driver.quit();          
	    }
		
	    /**
	     * This  method gets initiated fro actual test which creates 2 new issues and link them    *
	     */
	    
	    @Test(dataProvider="myData")
		 public void testUIAutomationFlow(Map<Object, Object> map)throws InterruptedException, IOException 
	    {
	    	FlightSearchPageObject searchObj = new FlightSearchPageObject(driver);
	    	searchObj.SearchFlight(map);
	    	
	    	BookingNavigationPageObject navigateObj = new BookingNavigationPageObject(driver);
	    	navigateObj.BookingNavigation();
	    	
	    	AddBaggagePageObject addBagaggeObj = new AddBaggagePageObject(driver);
	    	addBagaggeObj.AddBaggage(map);
	            
		        
	    }
	 

}
