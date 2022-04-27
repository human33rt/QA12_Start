package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitRegistrationForm() {
        click(By.xpath("//button[text()=' Registration']"));
    }

    public void fillLoginRegistrationForm(String email,String password) {
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);
    }
    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void submitLogin(){
        click(By.tagName("button"));
    }

}
