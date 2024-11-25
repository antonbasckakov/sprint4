import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.MainPage;
import pageobjects.OrderPage;
import pageobjects.RentPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BeforAndAfterTest {
    private MainPage mainPage;
    private OrderPage orderPage;
    private RentPage rentPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String date;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surname, String address,
                     String metroStation, String phone, String date,
                     String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Темная", "Алесса", "Сайлент Хилл", "Автозаводская", "+666666666666", "05.02.2024", "black", "если самокат не понравится она его спалит"},
                {"Джиперс", "Криперс", "Сельская местность Флориды", "Технопарк", "+666666666666", "06.06.2024", "grey", "Может принять заказ один раз в 23 года"},
        };
    }
    //ТЕСТ НИЖНЕЙ КНОПКИ
    @Test
    public void testHappyPathOrderByTopButton() {
        initializePageObjects();

        mainPage.clickCookieButton();
        mainPage.clickOrderButtonTop();
        assertOrderHeaderVisible();

        orderPage.fillOrderForm(name, surname, address, metroStation, phone);
        assertRentalHeaderVisible();

        rentPage.fillRentalForm(date, color, comment);
        waitForConfirmButtonAndClick();
        assertOrderConfirmationVisible();
    }

    @Test
    public void testHappyPathOrderByBottomButton() {
        initializePageObjects();
        mainPage.goToAndClickBottomOrderButton();
        assertOrderHeaderVisible();

        orderPage.fillOrderForm(name, surname, address, metroStation, phone);
        assertRentalHeaderVisible();

        rentPage.fillRentalForm(date, color, comment);
        waitForConfirmButtonAndClick();
        assertOrderConfirmationVisible();
    }

    private void initializePageObjects() {
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        rentPage = new RentPage(driver);
    }

    private void assertOrderHeaderVisible() {
        assertTrue("Заголовок страницы заказа должен отображаться", orderPage.isOrderHeaderVisible());
    }

    private void assertRentalHeaderVisible() {
        assertTrue("Заголовок страницы аренды должен отображаться", rentPage.isRentalHeaderVisible());
    }

    private void assertOrderConfirmationVisible() {
        assertTrue("Подтверждение заказа должно отображаться", rentPage.isOrderConfirmationVisible());
    }

    private void waitForConfirmButtonAndClick() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(RentPage.confirmButton));
        rentPage.clickConfirmButton();
    }
}
