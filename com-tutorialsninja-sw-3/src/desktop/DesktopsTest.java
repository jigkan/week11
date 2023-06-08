package desktop;

import homepage.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {
    String baseurl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);// instanting action class
        WebElement desk = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        actions.moveToElement(desk).click().build().perform();
        //Click on “Show All Desktops”
        WebElement desktops = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[1]/li[1]/div[1]/a"));
        desktops.click();
        //Select Sort By position "Name: Z to A"
        // WebElement sortby = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div[1]/select[1]"));
        // sortby.click();
        //  WebElement dorpdown=driver.findElement(By.xpath("div[@id='content']/div[3]/div[3]/div[1]/select[1]/option[3]"));
        //  dorpdown.click();
        ///// Verify the Product will arrange in Descending order.
        List<WebElement> beforeSortFilter = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));
        List<String> beforeSortFilters = new ArrayList<>();
        for (WebElement s : beforeSortFilter) {
            System.out.print(s.getText());
        }

        WebElement sort = driver.findElement(By.xpath("//select[@id='input-sort']"));
        sort.click();

        Select t = new Select(sort);
        t.selectByVisibleText("Name (Z - A)");
        List<WebElement> afterSortFilter = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));
        List<String> afterSortFilters = new ArrayList<>();
        for (WebElement as : afterSortFilter) {
            System.out.print(as.getText());
        }

        Collections.sort(beforeSortFilters);
        //Assert.assertNotEquals(beforeSortFilters, afterSortFilters);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        WebElement desk = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
        actions.moveToElement(desk).click().build().perform();
        //Click on “Show All Desktops”
        WebElement desktops = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[1]/li[1]/div[1]/a"));
        desktops.click();
        //2.3 Select Sort By position "Name: A to Z"
        WebElement sortby = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div[1]/select[1]"));
        sortby.click();
        //2.4 Select product “HP LP3065”
        WebElement dorpdown = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[3]/div[1]/select[1]/option[2]"));
        dorpdown.click();
        //Verify the Text "HP LP3065"
        driver.findElement(By.xpath("//div[@id='content']/div[4]/div[3]/div[1]/div[2]/div[1]/h4[1]/a")).click();//HPLP3065
        String actualtext = driver.findElement(By.xpath("//div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/h1 ")).getText();
        String expectedtext = "HP LP3065";
        Assert.assertEquals("verify text", expectedtext, actualtext);
        System.out.println(actualtext);
        //2.6 Select Delivery Date "2022-11-30"
        WebElement date = driver.findElement(By.xpath("//input[@id='input-option225']"));
        date.sendKeys("2022-11-30");

        WebElement Quantity = driver.findElement(By.xpath("//input[@id='input-quantity']"));
        Quantity.sendKeys("");
        //2.7.Enter Qty "1” using Select class.
        WebElement chart = driver.findElement(By.xpath("//button[@id='button-cart']"));
        chart.click();
        //verify msg add to cart

        // String actualtext1=driver.findElement(By.xpath("//div[@id='product-product']/div[1]/a")).getText();
        // System.out.println(actualtext1); verify not done
        //2.8 Click on “Add to Cart” button
        Actions action = new Actions(driver);
        WebElement shoppingchart = driver.findElement(By.xpath("/html/body/div[2]/div[1]/a[2]"));
        // WebElement shoppingchart=driver.findElement(By.linkText("shopping cart"));
        action.moveToElement(shoppingchart).click().build().perform();
        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        //2.12 Verify the Product name "HP LP3065"
       String actualprodcut = driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
       System.out.println(actualprodcut);
        String expectedprodcut = "HP LP3065";
       // Assert.assertEquals("verify text", expectedprodcut, actualprodcut);
        //2.13 Verify the Delivery Date "2022-11-30"
         String actualdate=driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[2]/small[1]")).getText();
        System.out.println(actualdate);
        String expecteddate="Delivery Date:2023-07-22";
        //Assert.assertEquals("verify text",expecteddate,actualdate);
        //2.14 Verify the Model "Product21"
        String actualmodel=driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[3]")).getText();
        System.out.println(actualprodcut);
        String expectedmodel="Product 21";
        // Assert.assertEquals("verify text",expectedprodcut,actualprodcut);
        //2.15 Verify the Todat "£74.73"
         String actualtotal=driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
         System.out.println(actualprodcut);
         String expectedtotal="$122.00";
        // Assert.assertEquals("verify text",expectedtotal,actualtotal);

    }}




