package aeroPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement aeroImg = $("[alt = '«Авиакомпания «Победа», Группа «Аэрофлот»']");
    private SelenideElement informationDropdown = $("a[href = '/information']");
    private SelenideElement headerOneOfInformationDropdown = $("a[href = '/information#flight'] div");
    private SelenideElement headerTwoOfInformationDropdown = $("a[href = '/information#useful'] div");
    private SelenideElement headerThreeOfInformationDropdown = $("a[href = '/information#company'] div");
    private SelenideElement bookingManagementTab = $("button.dp-re40sj:nth-child(3)");

    public void AeroImgIsDisplayed(){
       aeroImg.should(Condition.visible, Duration.ofSeconds(10));
    }

    public void hoverToInformationDropdown(){
        informationDropdown.hover();
    }

    public SelenideElement getHeaderOneOfInformationDropdown(){
        return headerOneOfInformationDropdown;
    }

    public SelenideElement getHeaderTwoOfInformationDropdown() {
        return headerTwoOfInformationDropdown;
    }

    public SelenideElement getHeaderThreeOfInformationDropdown() {
        return headerThreeOfInformationDropdown;
    }

    public BookingManagementForm clickToBookingManagementTab(){
        bookingManagementTab.click();
        return new BookingManagementForm();
    }

}
