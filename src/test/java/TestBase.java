import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {


    WebDriver wd;

@BeforeClass
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}
    @AfterClass
    public void tearDown(){
        wd.quit();
    }




    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }
    public void fillLoginRegistrationForm(String email,String password) {
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);
    }
    public void type(By locator, String text) {
        if(text !=null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void submitLoginRegistrationForm() {
        click(By.xpath("//button[text()='Sign Out']"));

}}
