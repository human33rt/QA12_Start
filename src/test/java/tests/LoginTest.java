package tests;//import org.junit.Test;
//import org.junit.Test;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test
    public void fillLoginFormTest() {
        //int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

//              User user = User.builder()
//                .email("noagmail.com")
//                .password("Nnoa12345$")
//                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
       Assert.assertTrue(app.getUser().isLogged());



    }


        @Test
        public void negativeLoginTest () {

            //int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String email = "noagmail.com";
            String password = "Nnoa12345$";
            System.out.println("Email: " + email);

            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm(email, password);
            app.getUser().submitLogin();
            //app.getUser().pause(5000);
            Assert.assertTrue(app.getUser().isWrongFormatPresent());        }

    }