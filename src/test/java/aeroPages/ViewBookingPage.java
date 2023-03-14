package aeroPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ViewBookingPage {
    private SelenideElement messageWithError = $("div.message_error");

    public String getTextFromMessageWithError(){
        return messageWithError.getText();
    }
}
