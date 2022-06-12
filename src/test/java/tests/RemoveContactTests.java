package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (!app.getUser().isLogged()) {
            app.getUser().login(new User()
                    .withEmail("noa@gmail.com")
                    .withPassword("Nnoa12345$"));
        }
        //providerContacts()===>3
        app.contact().providerOfContacts();
    }
    @Test
    public void removeOneContact(){
        //countStart
        app.contact().removeOneContact();
        //countEnd
        //Assert countStart - countEnd====== >=1
    }
//    @Test
//    public void removeOneContactCount(){
//        Assert.assertEquals(app.contact().removeOneContactCount(),-1);
//    }

    @Test
    public void removeAllContacts(){
        app.contact().removeAllContacts();
        //Assert.assertTrue(app.contact().isContactsListIsEmpty());
            }

}
