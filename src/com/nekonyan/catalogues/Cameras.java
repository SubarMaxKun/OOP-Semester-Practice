package com.nekonyan.catalogues;

import com.nekonyan.GoodsController;
import com.nekonyan.Router;
import com.nekonyan.UserController;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cameras {

  Scanner scanner = new Scanner(System.in);
  List<String> temps = new ArrayList<String>();
  GoodsController goodsController = new GoodsController();

  public void showCameraCatalogue() {
    try (Scanner file = new Scanner(
        new File("./src/com/nekonyan/resources/Cameras.txt")).useDelimiter("\n")) {
      String token;
      int currentItem = 0;

      while (file.hasNext()) {
        token = file.next();
        temps.add(token);
      }
      file.close();

      System.out.println("Виберіть фотоапарат для покупки:");
      String[] tempsArray = temps.toArray(new String[0]);
      for (String s : tempsArray) {
        currentItem += 1;
        System.out.println(currentItem + ") " + s.replace(":", "   "));
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
    System.out.println("0) - повернутися назад");
    defineChoosenItem();
  }

  private void defineChoosenItem() {
    while (true) {
      try {
        int choosenItem = scanner.nextInt();
        if (choosenItem <= temps.size() && choosenItem > 0) {
          // Змінити тут
          setChoosenItem(choosenItem - 1);
//          System.out.println(temps.get(choosenItem - 1));
          new Router().chooseCatalogue();
          break;
        } else if (choosenItem == 0) {
          new Router().chooseCatalogue();
          break;
        } else {
          System.out.println("Виберіть коректне значення:");
        }
      } catch (Exception e) {
        System.out.println("Виберіть коректне значення:");
        scanner.next();
      }
    }
  }

  private void setChoosenItem(int choosenItem) {
    String camera = temps.get(choosenItem);
    String[] splittedString = camera.split(":");
    goodsController.setCamera(splittedString[0], splittedString[1], splittedString[splittedString.length - 1]);
  }
}
