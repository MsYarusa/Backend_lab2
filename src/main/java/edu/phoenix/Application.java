package edu.phoenix;

import edu.phoenix.dao.Database;
import edu.phoenix.model.User;

import javax.xml.crypto.Data;

public class Application {

  public static void main(String[] args) {

    User user1 = new User("Petr Semenov", "Petka_krut", "1");
    User user2 = new User("Maria Petrova", "Mashka2008", "123321");
    User user3 = new User("Maria Ivanova", "Mashka2008", "00000");

    System.out.println("--------------1--------------");
    Database.addUser("Maria Petrova", "Mashka2008", "123321");
    System.out.println("--------------2--------------");
    Database.addUser("Maria Petrova", "Mashka2008", "123321");
    System.out.println("--------------3--------------");
    Database.getUser("Petek", "123455");

    System.out.println("--------------4--------------");
    Database.updateUser(user1);
    System.out.println("--------------5--------------");
    Database.updateUser(user2);
    System.out.println("--------------6--------------");
    Database.updateUser(user3);

  }
}
