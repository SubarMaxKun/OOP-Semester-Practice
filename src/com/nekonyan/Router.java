package com.nekonyan;

import com.nekonyan.authentication.Authorization;
import com.nekonyan.authentication.Registration;
import com.nekonyan.catalogues.Cameras;
import com.nekonyan.catalogues.Lenses;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Router {

  Scanner scanner = new Scanner(System.in);

  public void startSession() {

    try (BufferedReader br = new BufferedReader(
        new FileReader("./src/com/nekonyan/resources/Title.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (Exception e) {
      e.getStackTrace();
    }

    System.out.println(
        "Для продовження оберіть потрібний пункт:" + '\n' + "0) Вихід" + "\t\t\t"
            + "1) Реєстрація" + "\t\t\t" + "2) Авторизація");
    chooseAuthentication();
  }

  private void chooseAuthentication() {
    loop:
    while (true) {
      try {
        int choosenOption = scanner.nextInt();
        switch (choosenOption) {
          case 1 -> {
            new Registration().registration();
            break loop;
          }
          case 2 -> {
            new Authorization().authorization();
            break loop;
          }
          case 0 -> System.exit(0);
          default -> System.out.println("Виберіть коректне значення:");
        }
      } catch (Exception e) {
        System.out.println("Виберіть коректне значення:");
        scanner.next();
      }
    }
  }

  public void chooseCatalogue() {
    System.out.println(
        "Виберіть пункт меню:" + '\n' + "1) Об'єктиви" + "\t\t\t" + "2) Фотоапарати" + "\t\t\t"
            + "3) Кошик" + "\t\t\t" + "4) Вийти із акаунту" + "\t\t\t" + "0) Вийти із програми");
    loop:
    while (true) {
      try {
        int choosenOption = scanner.nextInt();
        switch (choosenOption) {
          case 1 -> {
            new Lenses().showLensCatalogue();
            break loop;
          }
          case 2 -> {
            new Cameras().showCameraCatalogue();
            break loop;
          }
          case 3 -> {
            new Cart().showCart();
            break loop;
          }
          case 4 -> {
            startSession();
            break loop;
          }
          case 0 -> System.exit(0);
          default -> System.out.println("Виберіть коректне значення:");
        }
      } catch (Exception e) {
        System.out.println("Виберіть коректне значення:");
        scanner.next();
      }
    }
  }

}