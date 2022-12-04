package com.nekonyan.catalogues;

import com.nekonyan.GoodsController;
import com.nekonyan.Router;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lenses {

  Scanner scanner = new Scanner(System.in);
  GoodsController goodsController = new GoodsController();
  List<String> temps = new ArrayList<>();

  public void showLensCatalogue() {
    try (Scanner file = new Scanner(
        new File("./resources/Lenses.txt")).useDelimiter("\n")) {
      String token;
      int currentItem = 0;

      while (file.hasNext()) {
        token = file.next();
        temps.add(token);
      }
      file.close();

      System.out.println("Виберіть об'єктив для покупки:");
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

  /**
   * @param choosenItem
   */
  private void setChoosenItem(int choosenItem) {
    String lens = temps.get(choosenItem);
    String[] splittedString = lens.split(":");
    goodsController.setLens(splittedString[0], splittedString[1],
        splittedString[splittedString.length - 1]);
  }
}
