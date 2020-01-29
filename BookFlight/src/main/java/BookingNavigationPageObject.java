import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class BookingNavigationPageObject {
	
	WebDriver driver;
	WebDriverWait wait; 
    
	static final Logger logger = Logger.getLogger(BookingNavigationPageObject.class);
	
    @FindBy(css=".e2e-cash-amount > .amount")
    WebElement CartAmount_Label;
    
    @FindBy(xpath="//upsell-fare-cell/div/label")
    WebElement RedDeal_Tab;
    
    @FindBy(css=".btn > .ng-tns-c66-8")
    WebElement AddToTrip_Button;
        
    @FindBy(xpath="//button[@id='btn-continue']")
    WebElement Continue_Button;
    
    @FindBy(css="#btn-continue > span")
    WebElement NextContinue_Button;
    
    
    @FindBy(xpath="//button[@id='btn-accept']")
    WebElement Accept_Button;
    
    
    public BookingNavigationPageObject(WebDriver driver)
    {    	 
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver,30);
    }
	
    public void LogMessage(String msg)
  	{		
  		BasicConfigurator.configure();
  		logger.getRootLogger().setLevel(Level.INFO);
  		logger.info(msg);
  		BasicConfigurator.resetConfiguration();
  		
  	}
	
	public void BookingNavigation()
	{
		
		
		int initialTotal = Integer.valueOf(CartAmount_Label.getText());
		
		LogMessage("SubTotal Cart Amount :" + initialTotal);
		
		wait.until(ExpectedConditions.visibilityOf(RedDeal_Tab));
        RedDeal_Tab.click();
        
            wait.until(ExpectedConditions.visibilityOf(AddToTrip_Button));
	        AddToTrip_Button.click();
        
	        int newTotal = Integer.valueOf(CartAmount_Label.getText());	        
	        if (initialTotal!= newTotal)
	        	LogMessage("SubTotal Cart Amount Updated :" + newTotal);
	        else
	        {
	        	LogMessage("SubTotal Cart Amount Not Updated - Failed ");
	        	Assert.fail();
	        }
	        
	        wait.until(ExpectedConditions.visibilityOf(Continue_Button));
	        Continue_Button.click();
	        
	        wait.until(ExpectedConditions.visibilityOf(NextContinue_Button));
	        NextContinue_Button.click();
	        
	        wait.until(ExpectedConditions.visibilityOf(Accept_Button));
	        Accept_Button.click();
	     
		
	}
	

}
