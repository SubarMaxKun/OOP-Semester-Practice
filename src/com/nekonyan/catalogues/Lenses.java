package com.nekonyan.catalogues;

import com.nekonyan.Router;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lenses {
  Scanner scanner = new Scanner(System.in);
  List<String> temps = new ArrayList<String>();

  public void showLensCatalogue() {
    try (Scanner inFile1 = new Scanner(
        new File("./src/com/nekonyan/resources/Lenses.txt")).useDelimiter("\n")) {
      String token;
      int currentItem = 0;

      while (inFile1.hasNext()) {
        token = inFile1.next().replace(":", "   ");
        temps.add(token);
      }
      inFile1.close();

      System.out.println("Виберіть об'єктив для покупки:");
      String[] tempsArray = temps.toArray(new String[0]);
      for (String s : tempsArray) {
        currentItem += 1;
        System.out.println(currentItem + ") " + s);
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
    System.out.println("0) - повернутися назад");
    setChoosenItem();
  }

  private void setChoosenItem() {
    while (true) {
      try {
        int a = scanner.nextInt();
        if (a <= temps.size() && a > 0) {
          // Змінити тут
          System.out.println(temps.get(a - 1)); //--------
          break;
        } else if (a == 0) {
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
}
