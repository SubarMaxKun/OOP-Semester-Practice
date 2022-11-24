package com.nekonyan.authentication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Registration {
  Scanner scanner = new Scanner(System.in);
  File file = new File("./src/com/nekonyan/resources/Users.txt");

  public void registration() throws IOException {
    boolean exist = file.exists();
    writeToFile(exist);
  }

  private void writeToFile(boolean append) throws IOException{
    String username;
    String password;

    System.out.println("Введіть логін:");
    username = scanner.nextLine();
    System.out.println("Введіть пароль:");
    password = scanner.nextLine();

    try (var fileWriter = new BufferedWriter(new FileWriter(file, append))){
      fileWriter.append(username + "|" + password);
      if (append){
        fileWriter.newLine();
      }
    }
  }
}
