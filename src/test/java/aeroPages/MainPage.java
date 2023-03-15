package aeroPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Проверка наличия логотипа")
    public void AeroImgIsDisplayed(){
       aeroImg.should(Condition.visible, Duration.ofSeconds(10));
    }
    @Step("Наведение курсора на выпадающий список 'Информация'")
    public void hoverToInformationDropdown(){
        informationDropdown.hover();
    }

    @Step("Получение текста из Заголовка №1 выпадающего списка 'Информация'")
    public SelenideElement getHeaderOneOfInformationDropdown(){
        return headerOneOfInformationDropdown;
    }
    @Step("Получение текста из Заголовка №2 выпадающего списка 'Информация'")
    public SelenideElement getHeaderTwoOfInformationDropdown() {
        return headerTwoOfInformationDropdown;
    }
    @Step("Получение текста из Заголовка №3 выпадающего списка 'Информация'")
    public SelenideElement getHeaderThreeOfInformationDropdown() {
        return headerThreeOfInformationDropdown;
    }
    @Step("Переход на страницу 'Управление бронированием'")
    public BookingManagementForm clickToBookingManagementTab(){
        bookingManagementTab.click();
        return new BookingManagementForm();
    }

}
