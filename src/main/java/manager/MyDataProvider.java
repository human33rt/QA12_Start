package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
   @DataProvider
    public Iterator<Object[]> fillLoginFormTest(){
       List<Object[]> list = new ArrayList<>();
       //list.add    ///////////////////     ////////////////////;
       //list.add    ///////////////////     ////////////////////;
       //list.add    ///////////////////     ////////////////////;
       return list.iterator();
   }

    @DataProvider//add string
    public Iterator<Object[]> RegValidData(){
        List<Object[]> list = new ArrayList<>();
        int i= (int) (System.currentTimeMillis()/1000)%3600;
        list.add(new Object[]{"noa"+i+"@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa"+i+"@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"noa"+i+"@gmail.com","Nnoa12345$"});
        return list.iterator();
    }
//
    @DataProvider //unreal in our case
   public Iterator<Object[]> ContactValidData(){
        List<Object[]> list = new ArrayList<>();

       list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
       list.add(new Object[]{"Hay","Low","1234567890","hay1@gmail.com","Haifa","Mother"});
       list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"});
       return list.iterator();
   }

    @DataProvider
    public Iterator<Object[]> loginValidDataModel(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});

        return list.iterator();
    }
//    @DataProvider
//    public Iterator<Object[]> loginValidDataModel(){
//        List<Object[]> list = new ArrayList<>();
//    list.add(new Object[]{User.builder().email("").password("")});
//    list.add(new Object[]{User.builder().email("").password("")});
//    list.add(new Object[]{User.builder().email("").password("")});
//        return list.iterator();
//    }

    //list.add(new Object[]{Contact.builder().name("").lastName("").build()}); example for lombock

//    @DataProvider
//    public Iterator<Object[]> loginValidDataModel(){
//        User user = User.builder()
//                .email("noa@gmail.com")
//                .password("Nnoa12345$")
//                .build();
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{user});
//        return list.iterator();
//
//    }


//    @DataProvider //add as user
//    public Iterator<Object[]> loginValidDataModel(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{new User().withEmail("").withPassword("")});
//        list.add(new Object[]{new User().withEmail("").withPassword("")});
//       list.add(new Object[]{new User().withEmail("").withPassword("")});
//        return list.iterator();
//    }

//    @DataProvider //add as Contact
//    public Iterator<Object[]> addContactValidDataModel(){
//        List<Object[]> list = new ArrayList<>();
//
//        // list.add(new Object[]{"Hay","Low","1234567890","hay@gmail.com","Haifa","Mother"}); example
//        //list.add(new Object[]{Contact.builder().name("").lastName("").build()}); example for lombock
//        list.add(new Object[]{new Contact().withName("").withLastName("").withPhone("").withEmail("").withAddress("").withDescription("")});
//        list.add(new Object[]{new Contact().withName("").withLastName("").withPhone("").withEmail("").withAddress("").withDescription("")});
//        list.add(new Object[]{new Contact().withName("").withLastName("").withPhone("").withEmail("").withAddress("").withDescription("")});
//        return list.iterator();
//    }
//
   @DataProvider //read from file for Contact
    public Iterator<Object[]> addContactValidDataCSV() throws IOException {
       List<Object[]> list = new ArrayList<>();
       BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/contacts.csv")));
       String line = reader.readLine();//Mona,Dow,3214598765,mona@gmail.com,Haifa,friend

//        BufferedReader reader = new BufferedReader(new FileReader(("src/test/resources/nn.csv")));
//        String line = reader.readLine();//Mona,Dow,3214598765,mona@gmail.com,Haifa,friend
//
////        while (line!=null){
////            String[]split = line.split(",");
////            list.add(new Object[]{ Contact.builder()
////                    .name(split[0])
////                .lastName(split[1])
////                .description(split[5])
////                .address(split[4])
////                .email(split[3])
////                .phone(split[2])
////                 .build()});
////            line= reader.readLine();
//        //    }

//       while (line!=null){
//           String[]split = line.split(",");
//           list.add(new Object[]{ Contact.builder()
//                   .Name(split[0])
//                   .LastName(split[1])
//                   .description(split[5])
//                   .Address(split[4])
//                   .email(split[3])
//                   .Phone(split[2])
//                   .build()});
//           line= reader.readLine();
//       }


       while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact()
                    .withName(split[0])
                    .withLastName(split[1])
                    .withPhone(split[2])
                    .withEmail(split[3])
                    .withAddress(split[4])
                    .withDescription(split[5])
            });
            line = reader.readLine();
        }
        return list.iterator();
  }

}
