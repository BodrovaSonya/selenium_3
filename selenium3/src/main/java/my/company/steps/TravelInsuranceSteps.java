package my.company.steps;

import my.company.pages.TravelInsurancePage;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by sonya on 31.01.2018.
 */
public class TravelInsuranceSteps {
    @Step ("получен заголовок страницы")
    public WebElement getTitle(){
        return new TravelInsurancePage().getTitle();
    }

    @Step("заголовок проверен по шаблону {0}")
    public void checkTitleErrorMessage(String errorMessage){
        new TravelInsurancePage().checkTitleErrorMessage(errorMessage);
    }

    @Step("произведено нажатие на кнопку для оформления заявки")
    public void checkOutOnline (){
        new TravelInsurancePage().checkOutOnline();
    }

    @Step("произведена смена рабочего окна")
    public void switchWindow () {
        new TravelInsurancePage().switchWindow();
    }
}
