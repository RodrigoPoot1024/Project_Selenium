package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjetBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObjetBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver,10);
    }

}
