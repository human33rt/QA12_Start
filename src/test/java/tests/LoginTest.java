package tests;//import org.junit.Test;
//import org.junit.Test;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test    //(dataProvider = "fillLoginFormTest", dataProviderClass = MyDataProvider.class)
    public void fillLoginFormTest() {
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
    public void loginSuccessTestDataProvider(User user) { //User user
      // User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

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
    public void loginSuccessTestModel() {
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test(dataProvider = "loginValidDataModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccessTestModelDataProvider(User user) {
      //User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

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