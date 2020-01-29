import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddBaggagePageObject {
	
WebDriver driver;WebDriverWait wait; 
static final Logger logger = Logger.getLogger(AddBaggagePageObject.class);
    
    @FindBy(css=".add-bag")
    WebElement AddBaggage_Link;
    
    
    
    @FindBy(css=".icon-chevron-right:nth-child(1)")
    WebElement BaggagePlus_Button;
    
    @FindBy(css=".e2e-cash-amount > .amount")
    WebElement CartAmount_Label;
    
    @FindBy(css="#bags-btn-continue > span")
    WebElement Continue_Button;
    
    
    @FindBy(css=".ng-tns-c113-78 .right-container > .btn")
    WebElement Accept_Button;
    
    
    public AddBaggagePageObject(WebDriver driver)
    {    	 
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver,30);
    }
	
	
	public void AddBaggage(Map<Object, Object> map)
	{
		wait.until(ExpectedConditions.visibilityOf(AddBaggage_Link));
		AddBaggage_Link.click();
		int numberOfBaggages = Integer.valueOf(map.get("Baggage").toString());
		
		for (int i=0;i<=numberOfBaggages;i++)
		{
			BaggagePlus_Button.click();
		}
		Continue_Button.click();
		Accept_Button.click();
		
		LogMessage("Updated amount after Additional Baggage :" + CartAmount_Label.getText());
		
	}
	
	public void LogMessage(String msg)
  	{		
  		BasicConfigurator.configure();
  		logger.getRootLogger().setLevel(Level.INFO);
  		logger.info(msg);
  		BasicConfigurator.resetConfiguration();
  		
  	}

}
