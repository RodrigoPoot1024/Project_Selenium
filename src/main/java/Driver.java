import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Objects;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(Driver.class.getResource("/chromeDriver/chromedriver.exe")).getFile());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void driverClose (){
        driver.close();
        driver = null;
    }
}
