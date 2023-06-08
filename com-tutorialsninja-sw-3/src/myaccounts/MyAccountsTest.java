package myaccounts;

import homepage.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountsTest extends BaseTest {
    String baseurl="https://tutorialsninja.com/demo/index.php";
    @Before
    public void setup(){openBrowser(baseurl);}
    public void selectMyAccountOptions(String option){
       if (option=="Register"){ driver.findElement(By.linkText("Register")).click();
                           }
       else if (option=="Login") {driver.findElement(By.linkText("Login")).click();
                               }
       else if (option=="Logout") {driver.findElement(By.xpath("//div[@id='top-links']/ul[1]/li[2]/ul[1]/li[5]/a")).click();
       }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //Clickr on My Account Link.
        WebElement cliclaccount=driver.findElement(By.linkText("My Account"));
        cliclaccount.click();

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        String actualRegistertext=driver.findElement(By.xpath("//div[@id='account-register']/div[1]/div[1]/h1")).getText();
        System.out.println(actualRegistertext);
        String expectedRegistertext="Register Account";
        Assert.assertEquals("verify text",expectedRegistertext,actualRegistertext);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Clickr on My Account Link.
        WebElement cliclaccount=driver.findElement(By.linkText("My Account"));
        cliclaccount.click();
       // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
      //  2.3 Verify the text “Returning Customer”.
        String actuallogintext=driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/h2")).getText();
        System.out.println(actuallogintext);
        String expectedlogintext="Returning Customer";
        Assert.assertEquals("verify text",expectedlogintext,actuallogintext);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Clickr on My Account Link.
        WebElement cliclaccount=driver.findElement(By.linkText("My Account"));
        cliclaccount.click();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        WebElement inputfirstname=driver.findElement(By.id("input-firstname"));
        inputfirstname.sendKeys("jignesh");
        // 3.4 Enter Last Name
        WebElement inputlastname=driver.findElement(By.id("input-lastname"));
        inputlastname.sendKeys("kanani");
        ///3.5 Enter Email
        WebElement inputemail=driver.findElement(By.id("input-email"));
        inputemail.sendKeys("ji@gmail.com");
        //3.6 Enter Telephone
        WebElement inputtelephone=driver.findElement(By.id("input-telephone"));
        inputtelephone.sendKeys("8796544545");
        //3.7 Enter Password
        WebElement inputpassword=driver.findElement(By.id("input-password"));
        inputpassword.sendKeys("123456");
        //3.8 Enter Password Confirm
        WebElement inputconfirm=driver.findElement(By.id("input-confirm"));
        inputconfirm.sendKeys("123456");
        //3.9 Select Subscribe Yes radio button
        WebElement radiobutton=driver.findElement(By.xpath("//Div[@class='form-group']/div[1]/label[1]/input"));
        radiobutton.click();
        //3.10 Click on Privacy Policy check box
        WebElement checkbox=driver.findElement(By.xpath("//Div[@class='pull-right']/input[1]"));
        checkbox.click();
       // 3.11 Click on Continue button
        WebElement continuebutton=driver.findElement(By.xpath("//Div[@class='pull-right']/input[2]"));
        continuebutton.click();
       // 3.12 Verify the message “Your Account Has Been Created!”
        String actualcreatedtext=driver.findElement(By.xpath("//div[@id='common-success']/div[1]/div[1]/h1")).getText();
        System.out.println(actualcreatedtext);
        String expectedcreatedtext="Your Account Has Been Created!";
        Assert.assertEquals("verify text",expectedcreatedtext,actualcreatedtext);
       // 3.13 Click on Continue button
        WebElement cbutton=driver.findElement(By.xpath("//div[@id='common-success']/div[1]/div[1]/div[1]/div[1]/a"));
        cbutton.click();
        //3.14 Clickr on My Account Link.
        driver.findElement(By.linkText("My Account")).click();
        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        String actuallogouttext=driver.findElement(By.xpath("//div[@id='common-success']/div[1]/div[1]/h1")).getText();
        System.out.println(actuallogouttext);
        String expectedlogouttext="Account Logout";
        Assert.assertEquals("verify text",expectedlogouttext,actuallogouttext);
        //3.17 Click on Continue button
        WebElement conbutton=driver.findElement(By.xpath("//div[@id='common-success']/div[1]/div[1]/div[1]/div[1]/a"));
        conbutton.click();
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
       // 4.1 Clickr on My Account Link.
        WebElement cliclaccount=driver.findElement(By.linkText("My Account"));
        cliclaccount.click();
       // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
       // 4.3 Enter Email address
        WebElement emailadd=driver.findElement(By.id("input-email"));
        emailadd.sendKeys("ji@gmail.com");
       // 4.5 Enter Password
        WebElement inpassword=driver.findElement(By.id("input-password"));
        inpassword.sendKeys("123456");
       // 4.6 Click on Login button
        WebElement loginbut=driver.findElement(By.xpath("//div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        loginbut.click();
       // 4.7 Verify text “My Account”
        String actualmyaccounttext=driver.findElement(By.xpath("//div[@id='account-account']/div[1]/div[1]/h2")).getText();
        System.out.println(actualmyaccounttext);
        String expectedmyaccounttext="My Account";
        Assert.assertEquals("verify text",expectedmyaccounttext,actualmyaccounttext);
       // 4.8 Clickr on My Account Link.
        driver.findElement(By.linkText("My Account")).click();
       // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions("Logout");
       // 4.10 Verify the text “Account Logout”
        String actuallogouttext=driver.findElement(By.xpath("//div[@id='common-success']/div[1]/div[1]/h1")).getText();
        System.out.println(actuallogouttext);
        String expectedlogouttext="Account Logout";
        Assert.assertEquals("verify text",expectedlogouttext,actuallogouttext);
       // 4.11 Click on Continue button
        WebElement conbutton=driver.findElement(By.xpath("//div[@id='common-success']/div[1]/div[1]/div[1]/div[1]/a"));
        conbutton.click();
    }


}
