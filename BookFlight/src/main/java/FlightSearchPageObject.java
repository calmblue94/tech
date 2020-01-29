import java.util.Map;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
* <h1>Apply for Number Plate Navigation Page</h1>
* 
* This is page factory Class for Navigating to Home Page for JIRA
* 
* @author  Arun Ramakrishnan
* @version 1.0
* @since   02-09-2019 
*/

public class FlightSearchPageObject {
	
	WebDriver driver;WebDriverWait wait; 
    
    @FindBy(id="typeahead-input-from")
    WebElement From_TextBox;
    
    @FindBy(id="typeahead-input-to")
    WebElement To_TextBox;
    
    @FindBy(id="typeahead-list-item-to-0")
    WebElement To_FirstItem_ListBox;
        
    @FindBy(id="datepicker-input-departureDate")
    WebElement DatePicker_Icon;
    
    
    @FindBy(css=".date-picker__calendar-weekdays-items--hovered .date-picker__calendar-weekdays-items-text")
    WebElement Date_Icon;
    
    
    @FindBy(xpath="(//button[@type='submit'])[4]")
    WebElement Submit_Button;
    
    @FindBy(xpath="//div[@id='flight-form']/form/div[3]/div/div[2]/div[2]/div/fieldset/div/div[2]/label/span")
    WebElement OneWay_RadioButton;
    
    
    public FlightSearchPageObject(WebDriver driver)
    {    	 
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver,30);
    }
	
	
	public void SearchFlight(Map<Object, Object> map)
	{
		 From_TextBox.click();
		 From_TextBox.sendKeys(map.get("From").toString());
		 
		 To_TextBox.click();
		 To_TextBox.sendKeys(map.get("To").toString());
		 To_FirstItem_ListBox.click();
              
		 OneWay_RadioButton.click();         
		 DatePicker_Icon.click();
         Date_Icon.click();
         
		 Submit_Button.click();
        
	}

}
