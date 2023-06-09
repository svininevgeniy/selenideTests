package aeroPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class SearchTicketsForm {
    private SelenideElement inputFieldFrom = $("#mantine-R2qualmqm-target");
    private SelenideElement inputFieldWhere = $("#mantine-R3qualmqm-target");
    private SelenideElement inputFieldDateFrom = $("input[placeholder='Туда']");
    private SelenideElement inputFieldDateTo = $("input[placeholder='Обратно']");
    private SelenideElement searchButton = $("button.dp-n39zqv");
    @Step("Проверка наличия элементов для поиска билетов")
    public void searchElementsAreDisplayed(){
        inputFieldFrom.shouldBe(Condition.visible);
        inputFieldWhere.shouldBe(Condition.visible);
        inputFieldDateFrom.shouldBe(Condition.visible);
        inputFieldDateTo.shouldBe(Condition.visible);
    }
    @Step("Поиск билетов из Мск в СПб без указания даты 'Туда'")
    public void enterSearchRequestMscSpb(){
        inputFieldFrom.sendKeys(Keys.LEFT_CONTROL + "A");
        inputFieldFrom.sendKeys(Keys.BACK_SPACE);
        inputFieldFrom.setValue("Москва");
        inputFieldWhere.sendKeys(Keys.LEFT_CONTROL + "A");
        inputFieldWhere.sendKeys(Keys.BACK_SPACE);
        inputFieldWhere.setValue("Санкт-Петербург");
        searchButton.click();
    }
    @Step("Проверка красной рамки у поля 'Туда'")
    public SelenideElement getInputFieldDateFrom(){
        return inputFieldDateFrom;
    }
}
