package aeroPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ViewBookingPage {
    private SelenideElement messageWithError = $("div.message_error");
    @Step("Получение текста с ошибкой")
    public String getTextFromMessageWithError(){
        return messageWithError.getText();
    }
}
