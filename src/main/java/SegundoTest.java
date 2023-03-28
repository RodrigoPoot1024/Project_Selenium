import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pom.Dominio.Amazon.AmazonCartInterface;
import pom.Dominio.Amazon.AmazonMainPo;
import pom.Dominio.Amazon.AmazonProductPo;
import pom.Dominio.Amazon.AmazonSearchResultPo;

public class SegundoTest {

    @Test
    public void tercerTest () throws InterruptedException {
        Driver.getDriver().get("https://www.amazon.com.mx/");
        AmazonMainPo amazonPo = new AmazonMainPo(Driver.getDriver());
        AmazonSearchResultPo amazonSearchResultPo = new AmazonSearchResultPo(Driver.getDriver());
        AmazonProductPo amazonProductPo = new AmazonProductPo(Driver.getDriver());
        AmazonCartInterface amazonCartInterface = new AmazonCartInterface(Driver.getDriver());
        amazonPo.fillSearchBar("escritorio");
        amazonPo.clickSearchButton();
        amazonSearchResultPo.clickProduct(3);
        try {
            amazonProductPo.suggestionProduct();
        }catch (TimeoutException e){
            e.getMessage();
        }
        amazonProductPo.addCart();
        amazonProductPo.validateProductIsAddedToCart();
        amazonPo.fillSearchBar("control xbox");
        amazonPo.clickSearchButton();
        amazonSearchResultPo.clickProduct(3);
        amazonProductPo.addCart();
        amazonProductPo.validateProductIsAddedToCart();
        amazonCartInterface.buttonCart();
        amazonCartInterface.deleteCart();
        Thread.sleep(10000);
    }

    /*@AfterTest
    public static void afterTest() {
        Driver.driverClose();
    }*/
}
