package com.nekonyan.authentication;

import com.nekonyan.Router;
import com.nekonyan.UserController;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registration {

  PasswordHasher passwordHasher = new PasswordHasher();
  UserController userController = new UserController();
  Scanner scanner = new Scanner(System.in);
  File file = new File("./resources/Users.txt");

  private String username;
  private String hashedPassword;

  public void registration() {
    System.out.println("Введіть логін:");
    username = scanner.nextLine();
    System.out.println("Введіть пароль:");
    String password = scanner.nextLine();
    passwordHasher.passwordHasher(password);
    hashedPassword = String.valueOf(passwordHasher.shaInBytes);
    boolean exist = file.exists();
    userController.createUser(username);
    writeToFile(exist);
    new Router().chooseCatalogue();
  }

  /**
   * @param append
   */
  private void writeToFile(boolean append) {
    try (var fileWriter = new BufferedWriter(new FileWriter(file, append))) {
      fileWriter.append(username).append(":").append(hashedPassword);
      fileWriter.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
