package com.nekonyan.catalogues;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Cameras {

  Scanner scanner = new Scanner(System.in);
  int choosenItem;

  public void showCameraCatalogue() {
    try (BufferedReader br = new BufferedReader(
        new FileReader("./src/com/nekonyan/resources/Cameras.txt"))) {
      String line;
      int a = 0;

      System.out.println("Виберіть камеру для покупки:");
      while ((line = br.readLine()) != null) {
        int currentItem = a += 1;
        System.out.println(a + ") " + line);
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
    System.out.println("0) - повернутися назад");
    setChoosenItem();
  }

  private void setChoosenItem() {
    loop:
    while (true) {
      try {
        scanner.nextInt();
        break loop;
      } catch (Exception e) {
        System.out.println("Виберіть коректне значення:");
        scanner.next();
      }
    }
  }
}
