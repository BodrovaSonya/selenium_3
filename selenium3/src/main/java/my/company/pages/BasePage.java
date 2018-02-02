package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sonya on 26.01.2018.
 */
public class BasePage {

    BasePage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void waitElement (WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
