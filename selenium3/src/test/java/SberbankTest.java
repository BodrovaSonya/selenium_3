import my.company.steps.BaseSteps;
import my.company.steps.MainSteps;
import my.company.steps.RequestSteps;
import my.company.steps.TravelInsuranceSteps;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;

public class SberbankTest extends BaseSteps{
    MainSteps mainSteps = new MainSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    RequestSteps requestSteps = new RequestSteps();
    HashMap <String, String> testData = new HashMap<>();

    @Title("Заявка на страхование в Сбербанке")
    @Test
    public void testSberbank(){
        testData.put("фамилия застрахованного", "Ivanov");
        testData.put("имя застрахованного", "Ivan");
        testData.put("дата рождения застрахованного", "01.01.1999");
        testData.put("фамилия", "Петров");
        testData.put("имя", "Петр");
        testData.put("отчество", "Петрович");
        testData.put("день рождения", "");
        testData.put("серия паспорта", "1234");
        testData.put("номер паспорта", "222222");
        testData.put("дата выдачи", "14.03.2009");
        testData.put("место выдачи", "Трололо");

        mainSteps.selectSection("Застраховать себя  и имущество");
        mainSteps.waitElement(mainSteps.getTravelInsuranceElement("Страхование путешественников"));
        mainSteps.travelInsurance("Страхование путешественников");

        travelInsuranceSteps.waitElement(travelInsuranceSteps.getTitle());
        travelInsuranceSteps.checkTitleErrorMessage("Страхование путешественников");
        travelInsuranceSteps.checkOutOnline();
        travelInsuranceSteps.switchWindow();

        requestSteps.chooseSum("Минимальная");
        requestSteps.execute();
        requestSteps.fillFields(testData);
        requestSteps.chooseGender("мужской");
        requestSteps.checkFields(testData);
        requestSteps.clickContinue();
        requestSteps.checkErrorMessage("Заполнены не все обязательные поля");
    }

}
