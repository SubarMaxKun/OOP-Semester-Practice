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
  Scanner scanner = new Scanner(System.in);
  File file = new File("./src/com/nekonyan/resources/Users.txt");
  private String username;
  private String password;
  private String hashedPassword;

  public void registration() throws IOException {
    System.out.println("Введіть логін:");
    username = scanner.nextLine();
    System.out.println("Введіть пароль:");
    password = scanner.nextLine();
    passwordHasher.passwordHasher(password);
    hashedPassword = String.valueOf(passwordHasher.shaInBytes);
    boolean exist = file.exists();
    new UserController().createUser(username);
    writeToFile(exist);
    new Router().chooseCatalogue();
  }

  private void writeToFile(boolean append) throws IOException {

    try (var fileWriter = new BufferedWriter(new FileWriter(file, append))) {
      fileWriter.append(username + ":" + hashedPassword);
      if (append) {
        fileWriter.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
