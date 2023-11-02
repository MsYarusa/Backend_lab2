package edu.phoenix.dao;

import edu.phoenix.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {

  static class UserNotFound extends Exception {
    public void errorMessage(){
      System.out.println("User has not been found");
    }
  }

  static class UserAlreadyAdded extends Exception {
    public void errorMessage(){
      System.out.println("User has already been added");
    }
  }

  public static List<User> dataBase = new ArrayList<>();

  public static void addUser(String name, String login, String password) {
    try{
      if (getUser(login, password) != null) {
        throw new UserAlreadyAdded();
      }else{
        dataBase.add(new User(name, login, password));
      }
    }catch(UserAlreadyAdded e){
      e.errorMessage();
    }
  }

  public static User getUser(String login, String password) {
    for (User user : dataBase) {
      if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
        return user;
      }
    }
    return null;
  }

  public static void deleteUser(String login) {
    dataBase.removeIf(user -> user.getLogin().equals(login));
  }

  public static void updateUser(User user) {
    try{
      if (dataBase.removeIf(user_db -> user_db.getLogin().equals(user.getLogin()))){
        dataBase.add(user);
      }else{
        throw new UserNotFound();
      }
    }catch(UserNotFound e){
      e.errorMessage();
    }
  }
}
