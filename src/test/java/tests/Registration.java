package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase {


    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

//    public void logout() {
//        click(By.xpath("//button[text()='Sign Out']"));
//    }
//
//    private boolean isLogged() {
//        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
//    }


    @Test
    public void successRegistrationTest(){

        int i= (int) (System.currentTimeMillis()/1000)%3600;
        String email = "noa"+i+"@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " +email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistrationForm();
        //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().isLogged());

    }

     @Test
    public void negativeRegistrationTest(){
        int i= (int) (System.currentTimeMillis()/1000)%3600;
        String email = "noa"+i+"gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " +email);

         app.getUser().openLoginRegistrationForm();
         app.getUser().fillLoginRegistrationForm(email,password);
         app.getUser().submitRegistrationForm();
         app.getUser().pause(5000);
         Assert.assertTrue(app.getUser().isWrongFormatPresent());

    }




}
