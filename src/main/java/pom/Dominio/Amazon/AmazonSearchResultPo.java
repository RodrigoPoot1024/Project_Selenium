package pom.Dominio.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.PageObjetBase;

public class AmazonSearchResultPo extends PageObjetBase {

    private String product = "//div[@data-cel-widget=\"search_result_%d\"]//img";


    public AmazonSearchResultPo(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void clickProduct (Integer integer){
        String xpath = String.format(product, integer);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(xpath)))
                .click();
    }
}
