package aeroTests;

import aeroPages.BookingManagementForm;
import aeroPages.MainPage;
import aeroPages.SearchTicketsForm;
import aeroPages.ViewBookingPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AeroTests {
    private String aeroUrl = "https://pobeda.aero/";
    private String aeroTitle = "Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы";

    @BeforeEach
    public void setUp(){
        //Step 1
        Selenide.open(aeroUrl);
    }

    @Test
    public void checkInformationDropdownTest(){

        //Step 2
        MainPage mainPage = new MainPage();
        Assertions.assertEquals(aeroTitle, Selenide.title());
        mainPage.AeroImgIsDisplayed();

        //Step 3
        mainPage.hoverToInformationDropdown();

        //Step 4
        String expectedHeader1 = "Подготовка к полёту";
        String expectedHeader2 = "Полезная информация";
        String expectedHeader3 = "О компании";

        mainPage.getHeaderOneOfInformationDropdown().shouldHave(Condition.text(expectedHeader1));
        mainPage.getHeaderTwoOfInformationDropdown().shouldHave(Condition.text(expectedHeader2));
        mainPage.getHeaderThreeOfInformationDropdown().shouldHave(Condition.text(expectedHeader3));
    }

    @Test
    public void searchTicketsTest(){

        //Step 2
        MainPage mainPage = new MainPage();
        Assertions.assertEquals(aeroTitle, Selenide.title());
        mainPage.AeroImgIsDisplayed();

        //Step 3
        SearchTicketsForm searchTicketsForm = new SearchTicketsForm();
        searchTicketsForm.searchElementsAreDisplayed();

        //Step 4 - 7
        String expectedColor = "rgba(185, 0, 85, 1)";
        searchTicketsForm.enterSearchRequestMscSpb();
        searchTicketsForm.getInputFieldDateFrom().shouldHave(Condition.cssValue("color", expectedColor));
    }

    @Test
    public void manageBookingTest(){

        //Step 2
        MainPage mainPage = new MainPage();
        Assertions.assertEquals(aeroTitle, Selenide.title());
        mainPage.AeroImgIsDisplayed();

        //Step 3
        BookingManagementForm bookingManagementForm = mainPage.clickToBookingManagementTab();

        //Step 4
        bookingManagementForm.bookingElementsAreDisplayed();

        //Step 5
        ViewBookingPage viewBookingPage = bookingManagementForm.searchOfIncorrectBooking();

        //Step 6
        // воспроизводится с очищенными куками
        String expectedMessage = "Заказ с указанными параметрами не найден";
        Assertions.assertEquals(expectedMessage, viewBookingPage.getTextFromMessageWithError());
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
