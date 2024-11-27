package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    //ЛОКАТОРЫ
    //Локатор заголовка формы заказа"Для кого самокат"
    private static final By orderHeader = By.className("Order_Header__BZXOb");
    //Локатор инпута "Имя"
    private static final By nameInput = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Имя']");
    //Локатор инпута "Фамилия"
    private static final By surnameInput = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Фамилия']");
    //Локатор инпута "Адрес:куда привезти заказ"
    private static final By addressInput = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Адрес: куда привезти заказ']");
    //Локатор инпута "Адрес:куда привезти заказ"
    private static final By phoneInput = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Телефон: на него позвонит курьер']");
    //Локатор селектора "Станция метро"
    private static final By stationInput = By.cssSelector(".select-search__input[placeholder='* Станция метро']");
    //Локатор кнопки "Далее"
    private static final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //МЕТОДЫ
    //Пользователь заполняет инпут "Имя"
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    //Пользователь заполняет инпут "Фамилия"
    public void enterSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }
    //Пользователь заполняет инпут "Адрес:куда привезти заказ"
    public void enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }
    //Пользователь выбирает из селектора "Станция метро" данные
    public void selectStation(String station) {
//        driver.findElement(By.cssSelector("[placeholder='* Станция метро']")).click();
        driver.findElement(stationInput).click();
        driver.findElement(By.xpath(".//button/div[text() = '" + station + "']")).click();
    }
    //Пользователь заполняет инпут "Телефон: на него позвонит курьер"
    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }
    //Пользователь кликает кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    //Пользователь видит заголовок "Для кого самокат"
    public boolean isOrderHeaderVisible() {
        return driver.findElement(orderHeader).isDisplayed();
    }
    //Шаг заполнение формы заказа (инпут "Имя",инпут "Фамилия", инпут "Адрес:куда привезти заказ", селектор "Станция метро", инпут "Телефон: на него позвонит курьер")
    public void fillOrderForm(String name, String surname, String address, String station, String phone) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        selectStation(station);
        enterPhone(phone);
        clickNextButton();
    }
}

