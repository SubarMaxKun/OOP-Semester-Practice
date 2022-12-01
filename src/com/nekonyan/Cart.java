package com.nekonyan;

import com.nekonyan.authentication.Authorization;
import com.nekonyan.authentication.Registration;
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
  Scanner scanner = new Scanner(System.in);

  public void showCart() {
    try (Scanner inFile1 = new Scanner(
        new File("./src/com/nekonyan/resources/" + userController.getUser() + "_cart"
            + ".txt")).useDelimiter("\n")) {
      String token;
      int currentItem = 0;

      while (inFile1.hasNext()) {
        token = inFile1.next();
        temps.add(token);
      }
      inFile1.close();

      System.out.println("--Предмети у вашому кошику--");
      String[] tempsArray = temps.toArray(new String[0]);
      for (String s : tempsArray) {
        currentItem += 1;
        System.out.println(currentItem + ") " + s.replace(":", "   "));
      }

      System.out.println("Виберіть пункт меню:" + '\n' + "1) Оформити замовлення" + "\t\t\t"
          + "0) Повернутися назад");
      chooseOption();
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

  private void chooseOption(){
    loop:
    while (true) {
      try {
        int choosenOption = scanner.nextInt();
        switch (choosenOption) {
          case 1 -> {
            new Order().createOrder();
            break loop;
          }
          case 0 -> new Router().chooseCatalogue();
          default -> System.out.println("Виберіть коректне значення:");
        }
      } catch (Exception e) {
        System.out.println("Виберіть коректне значення:");
        scanner.next();
      }
    }
  }
}
