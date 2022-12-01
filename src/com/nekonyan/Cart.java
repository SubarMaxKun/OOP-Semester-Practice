package com.nekonyan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cart {

  UserController userController = new UserController();
  File file = new File("./src/com/nekonyan/resources/" + userController.getUser() + ".txt");

  public void showCart() {
//    System.out.println(User.getUsername());
  }

  public void updateCart(String choosenItem) {
    boolean append = file.exists();

    try (var fileWriter = new BufferedWriter(new FileWriter(file, append))) {
      fileWriter.append(choosenItem);
      if (append) {
        fileWriter.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
