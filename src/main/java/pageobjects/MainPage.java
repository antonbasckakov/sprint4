package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    //ЛОКАТОРЫ
    private final WebDriver driver;
    //Верхняя кнопка "Заказать"
    private static final By orderButtonTop = By.className("Button_Button__ra12g");
    //Нижняя кнопка "Заказать"
    private static final By orderButtonBottom = By.xpath("//div[contains(@class, 'Home_ThirdPart__LSTEE')]//button[text()='Заказать']");
    //Кнопка куков "да все привыкли"
    private static final By cookieButton = By.className("App_CookieButton__3cvqF");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Локатор  вопроса списка
    private By getQuestionLocator(int questionIndex) {
        return By.id("accordion__heading-" + (questionIndex - 1));
    }
    // Локатор ответа списка
    public By getAnswerLocator(int answerIndex) {
        return By.id("accordion__panel-" + (answerIndex - 1));
    }

    //МЕТОДЫ СПИСКА ВОПРОСОВ
    //Скролл до списка
    public void clickQuestion(int questionIndex) {
        WebElement element = driver.findElement(getQuestionLocator(questionIndex));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    //Проверка отображения ответа
    public boolean isAnswerVisible(int answerIndex) {
        return driver.findElement(getAnswerLocator(answerIndex)).isDisplayed();
    }

    //МЕТОДЫ КНОПОК
    // Пользователь нажимает кнопку кук "да все привыкли"
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
   // Пользователь нажимает на верхнюю кнопку "Заказать"
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }
    // Пользователь нажимает на  нижнюю кнопку "Заказать"
    public void clickOrderButtonBottom() {
        WebElement element = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    // Пользователь скролится до нижней кнопку "Заказать"
    public void scrollToOrderButtonBottom() {
        WebElement element = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Шаг для нижней кнопки "Заказать"
    public void goToAndClickBottomOrderButton() {
        clickCookieButton();
        scrollToOrderButtonBottom();
        clickOrderButtonBottom();
    }
}