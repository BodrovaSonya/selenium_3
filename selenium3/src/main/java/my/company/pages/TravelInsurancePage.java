package my.company.pages;

import my.company.steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

/**
 * Created by sonya on 26.01.2018.
 */
public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//*[@class='sbrf-rich-outer']/h1")
    WebElement title;

    @FindBy(xpath = "//img[@src=\"/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53\"]")
    WebElement image;

    public TravelInsurancePage () {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public WebElement getTitle(){
        return title;
    }

    public void checkTitleErrorMessage(String errorMessage){
        String actualTitle = this.title.getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualTitle, errorMessage),
                actualTitle.contains(errorMessage));
    }

    public void checkOutOnline (){
        image.click();
    }

    public void switchWindow () {
        String parentWindow = BaseSteps.getDriver().getWindowHandle();
        Set<String> handles =  BaseSteps.getDriver().getWindowHandles();
        for(String windowHandle  : handles) {
            if (!windowHandle.equals(parentWindow)) {
                BaseSteps.getDriver().switchTo().window(windowHandle);
            }
        }
    }
}
