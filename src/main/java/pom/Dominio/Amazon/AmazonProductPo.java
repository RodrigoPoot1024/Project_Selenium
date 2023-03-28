package pom.Dominio.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pom.PageObjetBase;

public class AmazonProductPo extends PageObjetBase {

    private Integer initial;
    private Integer finalCount;

    @FindBy(xpath = "//a[@data-testid='adLinkPERC']")
    private WebElement productBanner;

    @FindBy (xpath = "//span[@id='submit.add-to-cart']")
    private WebElement addShoppingCart;

    @FindBy (xpath = "//span[@id=\"nav-cart-count\"]")
    WebElement cartCount;

    public AmazonProductPo(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void suggestionProduct (){
        WebElement suggestionProductIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='ape_Detail_hero-quick-promo_desktop_placement']//iframe")
        ));
        driver.switchTo().frame(suggestionProductIframe);
        wait.until(ExpectedConditions.elementToBeClickable(productBanner)).click();
    }


    public void addCart (){
        initial = counterCart();
        wait.until(ExpectedConditions.elementToBeClickable(addShoppingCart)).click();
        finalCount = counterCart();
    }

    public Integer counterCart (){
        wait.until(ExpectedConditions.visibilityOf(cartCount));
        return Integer.valueOf(cartCount.getText());
    }

    public void validateProductIsAddedToCart (){
        Assert.assertTrue(finalCount.equals(initial+1));
    }
}
