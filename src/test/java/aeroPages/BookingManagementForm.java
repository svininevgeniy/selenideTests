package aeroPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BookingManagementForm {
    private SelenideElement inputFieldSurname = $("input[placeholder='Фамилия клиента']");
    private SelenideElement inputFieldOrderNumber = $("input[placeholder = 'Номер заказа или билета']");
    private SelenideElement searchBookingButton = $("button.dp-ujv363");

    public void bookingElementsAreDisplayed(){
        inputFieldSurname.shouldBe(Condition.visible);
        inputFieldOrderNumber.shouldBe(Condition.visible);
        searchBookingButton.shouldBe(Condition.visible);
    }

    public ViewBookingPage searchOfIncorrectBooking(){
        inputFieldSurname.setValue("Qwerty");
        inputFieldOrderNumber.setValue("XXXXXX");
        searchBookingButton.click();
        return new ViewBookingPage();
    }
}
