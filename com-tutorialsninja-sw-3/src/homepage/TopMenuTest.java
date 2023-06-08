package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseTest{

String baseurl="https://tutorialsninja.com/demo/index.php";
    @Before
    public void setup(){
        openBrowser(baseurl);
    }


public String selectmenu(String menu){
   return menu;
        }

@Test
public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
   // Mouse hover on “Desktops” Tab and click
    Actions actions = new Actions(driver);// instanting action class
    WebElement desk=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a"));
    actions.moveToElement(desk).click().build().perform();
    //1.2 call selectMenu method and pass the menu = “Show All Desktops”
    selectmenu("Show AllDesktops");
   WebElement desktops=driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[1]/li[1]/div[1]/a"));
    desktops.click();
   // 1.3 Verify the text ‘Desktops’
   String actualtext=driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
    System.out.println(actualtext);
   String expectedtext="Desktops";
    Assert.assertEquals("verifying text", expectedtext,actualtext);
    System.out.println(actualtext);
}

@Test
public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //Mouse hover on “Laptops & Notebooks” Tab and click
    Actions actions = new Actions(driver);// instanting action class
    WebElement desk=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
    actions.moveToElement(desk).click().build().perform();
   // call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    selectmenu("Show AllLaptops & Notebooks");
    WebElement notebook=driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul[1]/li[2]/div[1]/a"));
    notebook.click();
    //Verify the text ‘Laptops & Notebooks’
    String actualtext=driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
    System.out.println(actualtext);
    String expectedtext="Laptops & Notebooks";
    Assert.assertEquals("verifying text", expectedtext,actualtext);
    System.out.println(actualtext);
}

@Test
public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
   // Mouse hover on “Components” Tab and click
    Actions actions = new Actions(driver);// instanting action class
    WebElement desk=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a"));
    actions.moveToElement(desk).click().build().perform();
    //call selectMenu method and pass the menu = “Show All Components”
    selectmenu("Show AllComponents");
    WebElement desktops=driver.findElement(By.xpath("//nav[@id='menu']/div[2]/ul[1]/li[3]/div[1]/a"));
    desktops.click();
    //Verify the text ‘Components’
    String actualtext=driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
    System.out.println(actualtext);
    String expectedtext="Components";
    Assert.assertEquals("verifying text", expectedtext,actualtext);
    System.out.println(actualtext);}

   /* mousehover(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
    selectmenu("Show AllLaptops & Notebooks");
    WebElement desktops=driver.findElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul[1]/li[2]/div[1]/div[1]/ul[1]/li[2]/a"));
    desktops.click();
    String actualtext=driver.findElement(By.xpath("//div[@id='product-category']/div[1]/div[1]/h2")).getText();
    System.out.println(actualtext);
    String expectedtext="Laptops & Notebooks";
    Assert.assertEquals("verifying text", expectedtext,actualtext);
    System.out.println(actualtext);*/



@After
    public void closebrowser(){
    closeBrowser();
}

}
