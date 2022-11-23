package com.nekonyan;

import com.nekonyan.authentication.Authorization;
import com.nekonyan.authentication.Registration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Router {

  Scanner scanner = new Scanner(System.in);

  public void StartSession() {

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
            + "1) Реєстрація"  + "\t\t\t" + "2) Авторизація");
    ChooseOption();
  }

  private void ChooseOption(){
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
}