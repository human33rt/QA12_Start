//import org.junit.Test;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

   // @Test
    //public void successLoginTest(){
        //WebElement element6 = wd.findElement(By.tagName("a"));
        //WebElement element4 = wd.findElement(By.cssSelector("a"));
        //WebElement element2 = wd.findElement(By.cssSelector("a[href='/login']"));
        //WebElement element3 = wd.findElement(By.cssSelector("[href='/login']"));
        //WebElement element1 = wd.findElement(By.id("root"));
        //WebElement element5 = wd.findElement(By.cssSelector("#root"));
        //WebElement elLink = wd.findElement(By.linkText("Login"));

   WebElement elLink = wd.findElement(By.xpath("//*[text()='Registration']"));

       // List<WebElement> list= wd.findElements(By.tagName("a"));
       // WebElement element=list.get(2);
        //element.click(); //click "LOGIN" button
        //element.clear();
        //element.sendKeys("Hello");//fill LoginRegistration form

    //}
    @Test
    public void fillLoginFormTest(){
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



    }

   @Test
    public void negativeLoginTest(){
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

        //click "LOGIN" button
        //open LoginRegistration form
        //fill LoginRegistration form
        //wrong email
        //submit
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }


}
