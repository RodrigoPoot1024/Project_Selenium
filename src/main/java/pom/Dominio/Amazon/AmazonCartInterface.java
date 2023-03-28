package pom.Dominio.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.PageObjetBase;

import java.util.List;

public class AmazonCartInterface extends PageObjetBase {

    @FindBy (xpath = "//a[@id=\"nav-cart\"]")
    private WebElement buttonCartInterface;

    @FindBy(xpath = "//span[@data-action=\"delete\"]//input")
    private List<WebElement> deleteProducts;

    public AmazonCartInterface(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void buttonCart (){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCartInterface)).click();
    }

    public void deleteCart () {
        deleteProducts.forEach(product -> wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//span[@data-action=\"delete\"]//input)[1]")))
                .click());
    }
}
