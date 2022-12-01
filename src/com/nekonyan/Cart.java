package com.nekonyan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {

  UserController userController = new UserController();
  File file = new File(
      "./src/com/nekonyan/resources/" + userController.getUser() + "_cart" + ".txt");
  List<String> temps = new ArrayList<String>();

  public void showCart() {
    try (Scanner inFile1 = new Scanner(
        new File("./src/com/nekonyan/resources/" + userController.getUser() + "_cart" + ".txt")).useDelimiter("\n")) {
      String token;
      int currentItem = 0;

      while (inFile1.hasNext()) {
        token = inFile1.next();
        temps.add(token);
      }
      inFile1.close();

      System.out.println("Виберіть об'єктив для покупки:");
      String[] tempsArray = temps.toArray(new String[0]);
      for (String s : tempsArray) {
        currentItem += 1;
        System.out.println(currentItem + ") " + s.replace(":", "   "));
      }
    } catch (Exception e) {
      System.out.println("--Ваш кошик поки що пустий, додайте предмети для того щоб продовжити--");
      new Router().chooseCatalogue();
    }
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
