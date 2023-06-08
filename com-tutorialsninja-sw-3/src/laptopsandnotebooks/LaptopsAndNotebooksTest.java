package laptopsandnotebooks;

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

public class LaptopsAndNotebooksTest extends BaseTest {
    String baseurl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        Actions actions = new Actions(driver);
        WebElement Labtop = driver.findElement(By.linkText("Laptops & Notebooks"));
        actions.moveToElement(Labtop).click().build().perform();
        WebElement Showall = driver.findElement(By.linkText("Show AllLaptops & Notebooks"));
        Showall.click();
        // select high to low printed when it was default
        List<WebElement> before_seected_high_to_low = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> BEFORESELECTEDHIGHTOLOW = new ArrayList<>();
        for (WebElement a : before_seected_high_to_low) {
            System.out.println(a.getText());
        }
        //select high to low
        WebElement sort = driver.findElement(By.xpath("//select[@id='input-sort']"));
        sort.click();
        Select sortselect = new Select(sort);
        sortselect.selectByVisibleText("Price (High > Low)");
        //////////////////verify high to low by printing high to low selected field
        List<WebElement> hightolow = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> AFTERSELECTEDHIGHTOLOW = new ArrayList<>();
        for (WebElement as : hightolow) {
            System.out.println(as.getText());
        }
        Collections.sort(BEFORESELECTEDHIGHTOLOW);//to verify order arrange in sequence
        // Assert.assertNotEquals(BEFORESELECTEDHIGHTOLOW,AFTERSELECTEDHIGHTOLOW);
    }

      @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        //Mouse hover on Laptops & Notebooks Tab and click
        Actions actions=new Actions(driver);
          WebElement Labtop=driver.findElement(By.linkText("Laptops & Notebooks"));
          actions.moveToElement(Labtop).click().build().perform();
          //2.2 Click on “Show All Laptops & Notebooks”
          WebElement Showall=driver.findElement(By.linkText("Show AllLaptops & Notebooks"));
          Showall.click();
          // 2.3 Select Sort By "Price (High > Low)"
          WebElement sort =driver.findElement(By.xpath("//select[@id='input-sort']"));
          sort.click();
          Select sortselect=new Select(sort);
          sortselect.selectByVisibleText("Price (High > Low)");
          //2.4 Select Product “MacBook”
          WebElement selecmackbook=driver.findElement(By.linkText("MacBook"));
          selecmackbook.click();
          //2.5 Verify the text “MacBook”
          String actualprodcut=driver.findElement(By.linkText("MacBook")).getText();
          System.out.println(actualprodcut);
          String expectedprodcut="MacBook";
          Assert.assertEquals("verify text",expectedprodcut,actualprodcut);
          Actions action2=new Actions(driver);
          //2.6 Click on ‘Add To Cart’ button
          WebElement AddtoCart=driver.findElement(By.xpath("//div[@id='product']/div[1]/button[1]"));
          actions.moveToElement(AddtoCart).click().build().perform();
          Actions action3=new Actions(driver);
          //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”

          ///////////////verify text not done
          //2.8 Click on link “shopping cart” display into success message
          WebElement shoppingcart=driver.findElement(By.linkText("shopping cart"));
          action3.moveToElement(shoppingcart).click().build().perform();
          ////////////////verification not done
          //2.10 Verify the Product name "MacBook"
          String actualprodcutname=driver.findElement(By.linkText("MacBook")).getText();
          System.out.println(actualprodcut);
          String expectedprodcutname="MacBook";
          Assert.assertEquals("verify text",expectedprodcut,actualprodcut);
          //2.11 Change Quantity "2"remove 1 and add2//*[@id="content"]/form/div/table/tbody/tr/td[4]/div/input
          WebElement quantitychange=driver.findElement(By.xpath("//div[@id='content']/form/div[1]/table/tbody/tr/td[4]/div[1]/input"));
          quantitychange.clear();
          quantitychange.sendKeys("2");
          //2.12 Click on “Update” Tab
          WebElement submitbutton=driver.findElement(By.xpath("//button[@type='submit']"));
          submitbutton.click();
          //2.13 Verify the message “Success: You have modified your shopping cart!”
         String actualmodifiedyourshoppingcarttext=driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")).getText();
         System.out.println(actualmodifiedyourshoppingcarttext);
         String expectedmodifiedyourshoppingcarttext="Success: You have modified your shopping cart!\n" +
                 "×";
         Assert.assertEquals("verify text",expectedmodifiedyourshoppingcarttext,actualmodifiedyourshoppingcarttext);
      //2.14 Verify the Total £737.45
          String actualtotaltext=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")).getText();
          System.out.println(actualtotaltext);
          String expectedtotaltext="$1,204.00";
          Assert.assertEquals("verify text",expectedtotaltext,actualtotaltext);
          //2.15 Click on “Checkout” button
          WebElement chechout=driver.findElement(By.xpath("//div[@id=\"content\"]/div[3]/div[2]/a"));
          chechout.click();
          //2.16 Verify the text “Checkout”
          String actualchechouttext=driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/h1")).getText();
          System.out.println(actualchechouttext);
          String expectedchechouttext="Checkout";
          Assert.assertEquals("verify text",expectedchechouttext,actualchechouttext);
          //2.17 Verify the Text “New Customer”
          String actualcustomertext=driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2")).getText();
          System.out.println(actualmodifiedyourshoppingcarttext);
          String expectedcustomertext="New Customer";
          Assert.assertEquals("verify text",expectedcustomertext,actualcustomertext);
          //2.18 Click on “Guest Checkout” radio button
          WebElement guestchechout=driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input"));
          guestchechout.click();
          //2.19 Click on “Continue” tab
          WebElement continuetab=driver.findElement(By.xpath("//div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
          continuetab.click();
          //2.20 Fill the mandatory fields
          WebElement paymentfirstname=driver.findElement(By.id("input-payment-firstname"));
          paymentfirstname.sendKeys("Jignesh");
          WebElement paymentlastname=driver.findElement(By.id("input-payment-lastname"));
          paymentlastname.sendKeys("patel");
          WebElement paymentemail=driver.findElement(By.id("input-payment-email"));
          paymentemail.sendKeys("jignesh@gmail.com");
          WebElement paymenttelephone=driver.findElement(By.id("input-payment-telephone"));
          paymenttelephone.sendKeys("08756869545");
          WebElement paymentaddress1=driver.findElement(By.id("input-payment-address-1"));
          paymentaddress1.sendKeys("20,maybank avenue");
          WebElement paymentcity=driver.findElement(By.id("input-payment-city"));
          paymentcity.sendKeys("london");
          WebElement paymentostcode=driver.findElement(By.id("input-payment-postcode"));
          paymentostcode.sendKeys("3456787");
          WebElement paymentcountry=driver.findElement(By.id("input-payment-country"));
          Select county=new Select(paymentcountry);
          county.selectByVisibleText("United Kingdom");
          WebElement paymentzone=driver.findElement(By.id("input-payment-zone"));
          Select zone=new Select(paymentzone);
          zone.selectByVisibleText("Devon");
          //2.21 Click on “Continue” Button
          WebElement buttonguest=driver.findElement(By.id("button-guest"));
          buttonguest.click();
          //2.22 Add Comments About your order into text area
          WebElement addcomments=driver.findElement(By.xpath("//div[@id='collapse-payment-method']/div[1]/p[2]/textarea"));
          addcomments.sendKeys("when i will get my order");
          //2.23 Check the Terms & Conditions check box
          WebElement Term=driver.findElement(By.xpath("//div[@id='collapse-payment-method']/div[1]/div[2]/div[1]/input[1]"));
          Term.click();
          //2.24 Click on “Continue” button
          WebElement continuebutton=driver.findElement(By.xpath("//div[@id='collapse-payment-method']/div[1]/div[2]/div[1]/input[2]"));
          continuebutton.click();
         //2.25 Verify the message “Warning: Payment method required!”
         // String actualwarningtext=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']/text()")).getText();
         // System.out.println(actualwarningtext);
         // String expectedwarningtext="Warning: Payment method required!";
         // Assert.assertEquals("verify text",expectedwarningtext,actualwarningtext);


      }
}


