import org.junit.Test;
import org.openqa.selenium.By;
import my.company.pages.MainPage;
import my.company.pages.RequestPage;
import my.company.pages.TravelInsurancePage;

public class SberbankTest extends BaseTest{
    @Test
    public void testSberbank(){
        MainPage mainPage = new MainPage();
        mainPage.selectSection("Застраховать себя  и имущество");
        mainPage.waitElement(mainPage.getTravelInsuranceElement("Страхование путешественников"));
        mainPage.travelInsurance("Страхование путешественников");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage();
        travelInsurancePage.waitElement(travelInsurancePage.getTitle());
        travelInsurancePage.checkTitleErrorMessage("Страхование путешественников");
        travelInsurancePage.checkOutOnline();
        travelInsurancePage.switchWindow();

        RequestPage requestPage = new RequestPage(driver);
        requestPage.chooseSum("Минимальная");
        requestPage.execute();

        requestPage.fillField("фамилия застрахованного", "Ivanov");
        requestPage.fillField("имя застрахованного", "Ivan");
        requestPage.fillField("дата рождения застрахованного", "01.01.1999");
        requestPage.fillField("фамилия", "Петров");
        requestPage.fillField("имя", "Петр");
        requestPage.fillField("отчество", "Петрович");
        requestPage.fillField("день рождения", "01.01.1989");
        requestPage.fillField("серия паспорта", "1234");
        requestPage.fillField("номер паспорта", "222222");
        requestPage.fillField("дата выдачи", "14.03.2009");
        requestPage.fillField("место выдачи", "Трололо");
        requestPage.chooseGender("мужской");

        requestPage.checkFields("фамилия застрахованного","Ivanov");
        requestPage.checkFields("имя застрахованного","Ivan");
        requestPage.checkFields("дата рождения застрахованного", "01.01.1999");
        requestPage.checkFields("фамилия", "Петров");
        requestPage.checkFields("имя", "Петр");
        requestPage.checkFields("отчество", "Петрович");
        requestPage.checkFields("день рождения", "");
        requestPage.checkFields("серия паспорта", "1234");
        requestPage.checkFields("номер паспорта", "222222");
        requestPage.checkFields("дата выдачи", "14.03.2009");
        requestPage.checkFields("место выдачи", "Трололо");

        requestPage.clickContinue();
        requestPage.checkErrorMessage("Заполнены не все обязательные поля");

    }

    public void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

}
