import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public abstract class BeforAndAfterTest {
    protected WebDriver driver;

    @Before
    //ЗАПУСК БРАУЗЕРА

    public void setUp() {

        //  В CROME
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver = getWebBrauser("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //  В FIREFOX
//       WebDriverManager.firefoxdriver().setup();
//      driver = new FirefoxDriver();
////      driver = getWebBrauser("firefox");
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    //ЗАКРЫТИЕ БРАУЗЕРА
    public void teardown() {
        driver.quit();
    }
// Я так и не допер как запустить тесты по очереди в каждом браузере
//public WebDriver getWebBrauser (String brouser){
//        if (brouser.equals("firefox")){
//            return new FirefoxDriver();
//        } else  {
//        return new ChromeDriver();
//    }
//
//}

}
