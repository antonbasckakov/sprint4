package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentPage {
    //ЛОКАТОРЫ
    //Заголовка "Про аренду"
    public static final By rentalHeader = By.className("Order_Header__BZXOb");
    //Кнопка "да" модального окна "Хотите оформить заказ?"
    public static final By confirmButton = By.xpath("//button[text()='Да']");
    //Инпут "Когда привезете самокат" выбора даты
    private static final By deliveryDateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Селектор "Срок аренды"
    private static final By rentalDurationDropdown = By.className("Dropdown-placeholder");
    //Элемент селектора"Срок аренды" ("Трое суток")
    private static final By rentalDuration = By.xpath("//div[contains(text(), 'трое суток')]");
    // Чекбокс "Черный самокат" поля "Цвет самоката"
    private static final By scooterColorCheckboxBlack = By.xpath("//label[@for='black']/input");
    // Чекбокс "Серая безысходность" поля "Цвет самоката"
    private static final By scooterColorCheckboxGrey = By.xpath("//label[@for='grey']/input");
    //Текстовое поле "Комментарий для курьера"
    private static final By courierCommentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Верхняя кнопка "Заказать"
    private static final By orderButton = By.xpath("//button[text()='Заказать']");
    //Нижняя кнопка "Заказать"
    private static final By orderButtonRental = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    //Заголовок "Хотите оформить заказ?" модального окна подтверждения заказа
    private static final By orderConfirmation = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    //Кнопка "Посмотреть статус заказа"
    private static final By orderButtonLookAtTheStatus = By.xpath("//button[text()='Посмотреть статус']");
    private final WebDriver driver;


    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    //Пользователь вводит дату
    public void enterDeliveryDate(String date) {
        driver.findElement(deliveryDateInput).sendKeys(date);
    }

   //Пользователь кликает чекбоксы поля "Цвет самоката"
    public void selectScooterColor(String color) {
        if (color.equalsIgnoreCase("black")) {
            driver.findElement(scooterColorCheckboxBlack).click();
        } else if (color.equalsIgnoreCase("grey")) {
            driver.findElement(scooterColorCheckboxGrey).click();
        }
    }
    //Пользователь кликает по селектору "Срок аренды"
    public void openRentalDurationDropdown() {
        driver.findElement(rentalDurationDropdown).click();
    }
    //Пользователь выбирает элемент "трое суток" в селекторе "Срок аренды"
    public void selectRentalDuration() {
        driver.findElement(rentalDuration).click();
    }
    //Пользователь вводит коометарий в поле "Комметарий"
    public void enterCourierComment(String comment) {
        driver.findElement(courierCommentInput).sendKeys(comment);
    }
    //Пользователь кликает верхнюю кнопку заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    //Пользователь кликает нижнюю кнопку заказать
    public void clickOrderButtonRental() {
        driver.findElement(orderButtonRental).click();
    }
    //Пользователь кликает унопку "Да" модального окна
    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }
    //Пользователь видит текст заголовка "Про аренду"
    public boolean isRentalHeaderVisible() {
        return driver.findElement(rentalHeader).isDisplayed();
    }
    //Пользователь видит текст "Хотите оформить заказ?" модального окна подтверждения заказа
    public boolean isOrderConfirmationVisible() {
        return driver.findElement(orderConfirmation).isDisplayed();
    }
    //Пользователь кликает на кнопку "Посмотреть статус" модального окна подтверждения заказа
    public void clickButtonLookAtTheStatus() {
        driver.findElement(orderButtonLookAtTheStatus).click();
    }
    // Шаг
    public void fillRentalForm(String date, String color, String comment) {
        enterDeliveryDate(date);
        clickOrderButton();
        openRentalDurationDropdown();
        selectRentalDuration();
        selectScooterColor(color);
        enterCourierComment(comment);
        clickOrderButtonRental();
    }
}


