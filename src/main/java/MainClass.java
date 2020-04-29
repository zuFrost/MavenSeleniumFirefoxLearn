import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\java\\JavaProjects\\SeleniumJavaProjects\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.selenium.dev/");
    }
}
