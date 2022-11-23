package com.nekonyan;

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
        "Для продовження оберіть потрібний пункт:" + '\n' + "1) Реєстрація" + "\t\t\t"
            + "2) Авторизація");


  }
}