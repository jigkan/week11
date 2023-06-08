package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResisterTest extends BaseTest {
    String baseurl="https://parabank.parasoft.com/parabank";
    @Before
    public void setup()
    {openBrowser(baseurl);}
    @Test
    public void verifyThatSigningUpPageDisplay(){
        WebElement register=driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        register.click();
        String actualtext=driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText();
        String expectedtext="Signing up is easy!";
        Assert.assertEquals("Verfying text",expectedtext,actualtext);
        System.out.println(actualtext);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a")).click(); //register
        driver.findElement(By.id("customer.firstName")).sendKeys("jignesh");
        driver.findElement(By.id("customer.lastName")).sendKeys("Kanani");
        driver.findElement(By.id("customer.address.street")).sendKeys("20, MAybank Avenue");
        driver.findElement(By.id("customer.address.city")).sendKeys("london");
        driver.findElement(By.id("customer.address.state")).sendKeys("UK");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("09898567898");
        driver.findElement(By.id("customer.ssn")).sendKeys("dfdsfddf");
        driver.findElement(By.id("customer.username")).sendKeys("jayeshpatel");
        driver.findElement(By.id("customer.password")).sendKeys("Jignesh123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Jignesh123");
        driver.findElement(By.xpath("//form[@id='customerForm']/table[1]/tbody[1]/tr[13]/td[2]/input")).click();
        String actualtext=driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        String expectedtext="Your account was created successfully. You are now logged in.";
        Assert.assertEquals("Verfying text",expectedtext,actualtext);
        System.out.println(actualtext);}
        @Test
        public void userShouldLoginSuccessfullyWithValidCredentials(){
          driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[1]/input")).sendKeys("jayeshpatel");
          driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[2]/input")).sendKeys("Jignesh123");
            driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[3]/input")).click();
            String actualtext=driver.findElement(By.xpath("//div[@id='rightPanel']/div[1]/div[1]/h1")).getText();
            String expectedtext="Accounts Overview";
            Assert.assertEquals("Verfying text",expectedtext,actualtext);
            System.out.println(actualtext);
    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[1]/input")).sendKeys("jayeshpate");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[2]/input")).sendKeys("Jignesh12");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[3]/input")).click();
    }
    @Test
    public void userShouldLogOutSuccessfully (){
        driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[1]/input")).sendKeys("jayeshpatel");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[2]/input")).sendKeys("Jignesh123");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form[1]/div[3]/input")).click();
        driver.findElement(By.xpath("//div[@id='leftPanel']/ul[1]/li[8]/a")).click();
        String actualtext=driver.findElement(By.xpath("//div[@id='leftPanel']/h2")).getText();
        String expectedtext="Customer Login";
        Assert.assertEquals("Verfying text",expectedtext,actualtext);
        System.out.println(actualtext);


    }
}




