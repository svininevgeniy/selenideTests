package aeroPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class SearchTicketsForm {
    private SelenideElement inputFieldFrom = $("#mantine-R2qualmqm-target");
    private SelenideElement inputFieldWhere = $("#mantine-R3qualmqm-target");
    private SelenideElement inputFieldDateFrom = $("input[placeholder='Туда']");
    private SelenideElement inputFieldDateTo = $("input[placeholder='Обратно']");
    private SelenideElement searchButton = $("button.dp-n39zqv");

    public void searchElementsAreDisplayed(){
        inputFieldFrom.shouldBe(Condition.visible);
        inputFieldWhere.shouldBe(Condition.visible);
        inputFieldDateFrom.shouldBe(Condition.visible);
        inputFieldDateTo.shouldBe(Condition.visible);
    }

    public void enterSearchRequestMscSpb(){
        inputFieldFrom.sendKeys(Keys.LEFT_CONTROL + "A");
        inputFieldFrom.sendKeys(Keys.BACK_SPACE);
        inputFieldFrom.setValue("Москва");
        inputFieldWhere.sendKeys(Keys.LEFT_CONTROL + "A");
        inputFieldWhere.sendKeys(Keys.BACK_SPACE);
        inputFieldWhere.setValue("Санкт-Петербург");
        searchButton.click();
    }

    public SelenideElement getInputFieldDateFrom(){
        return inputFieldDateFrom;
    }
}
