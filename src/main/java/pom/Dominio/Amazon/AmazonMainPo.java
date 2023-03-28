package pom.Dominio.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.PageObjetBase;

public class AmazonMainPo extends PageObjetBase {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    public AmazonMainPo(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillSearchBar(String value){
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(value);
    }

    public void clickSearchButton (){
        searchButton.click();
    }

}
