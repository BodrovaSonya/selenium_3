package my.company.steps;

import my.company.pages.MainPage;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by sonya on 31.01.2018.
 */
public class MainSteps {
    @Step ("выбран пункт меню {0}")
    public void selectSection (String name) {
        new MainPage().selectSection(name);
    }

    @Step ("выбран вид страхования {0}")
    public void travelInsurance (String name) {
        new MainPage().travelInsurance(name);
    }

    @Step ("получен вид страхования {0}")
    public WebElement getTravelInsuranceElement (String name) {
        return new MainPage().getTravelInsuranceElement(name);
    }

    @Step ("ожидание элемента {0}")
    public void waitElement (WebElement element) {
        new MainPage().waitElement(element);
    }
}
