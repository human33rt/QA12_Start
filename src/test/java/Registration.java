import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Registration {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void successRegisrationTest(){
        WebElement element = wd.findElement(By.cssSelector("[href='/login']"));
        element.click();

        List<WebElement> list= wd.findElements(By.tagName("input"));

        WebElement inputEmail=list.get(0);
        WebElement inputPassword=list.get(1);

        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("noa@gmail.com");

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Nnoa12345$");

        WebElement buttonLogin = wd.findElement(By.tagName("button"));
        buttonLogin.click();

        //click "LOGIN" button
        //open LoginRegistration form
        //fill LoginRegistration form
        //submit
    }

    @Test
    public void negativeRegistrationTest(){
        WebElement element = wd.findElement(By.cssSelector("[href='/login']"));
        element.click();

        List<WebElement> list= wd.findElements(By.tagName("input"));

        WebElement inputEmail=list.get(0);
        WebElement inputPassword=list.get(1);

        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("noagmail.com");

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Nnoa12345$");

        WebElement buttonLogin = wd.findElement(By.tagName("button"));
        buttonLogin.click();
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }


}
