import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHelper {
    public static WebDriver WEB_DRIVER;
    //    System.setProperty("webdriver.gecko.driver", "C:\\java\\JavaProjects\\SeleniumJavaProjects\\drivers\\geckodriver.exe");
    WebDriverHelper() {
        WEB_DRIVER = new FirefoxDriver();
    }

    public WebElement getElements(String path) {
        return WEB_DRIVER.findElement(By.id(path));  // не корректно, работает как заглушка
    }



}
