package com.nekonyan.authentication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Authorization {

  Scanner scanner = new Scanner(System.in);
  PasswordHasher passwordHasher = new PasswordHasher();
  File file = new File("./src/com/nekonyan/resources/Users.txt");

  private String username;
  private String password;
  private String hashedPassword;

  public void authorization() throws IOException {
    System.out.println("Введіть логін:");
    username = scanner.nextLine();
    System.out.println("Введіть пароль:");
    password = scanner.nextLine();
    passwordHasher.passwordHasher(password);
    hashedPassword = passwordHasher.shaInBytes;
    if (checkAuthenticity()){
      System.out.println("cool");
    }
    else {
      System.out.println("bad");
    }
  }

  private boolean checkAuthenticity() throws IOException {
    String line;
    String[] userInfo;
    try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
      while ((line = reader.readLine()) != null) {
        userInfo = line.split(":");
        if (userInfo[0].equals(username) && userInfo[1].equals(hashedPassword)) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
