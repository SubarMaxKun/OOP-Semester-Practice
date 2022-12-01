package com.nekonyan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {

  UserController userController = new UserController();
  List<String> temps = new ArrayList<String>();

  public void createOrder() throws IOException {
    readOrder();
  }

/*  private void readOrder() {
    try (Scanner inFile1 = new Scanner(
        new File("./src/com/nekonyan/carts_orders/" + userController.getUser() + "_cart"
            + ".txt")).useDelimiter("\n")) {
      String token;

      while (inFile1.hasNext()) {
        token = inFile1.next();
        temps.add(token);
      }
      inFile1.close();

      String[] tempsArray = temps.toArray(new String[0]);
      FileWriter fileWriter = new FileWriter(
          "./src/com/nekonyan/carts_orders/" + userController.getUser() + "_order" + ".txt");
      for (String s : tempsArray) {
        fileWriter.write(s.replace(":", "   "));
        fileWriter.close();
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
    System.out.println("0) - повернутися назад");
  }*/

  private void readOrder() throws IOException {
    File a = new File("./src/com/nekonyan/carts_orders/" + userController.getUser() + "_cart"
        + ".txt");
    File b = new File("./src/com/nekonyan/carts_orders/" + userController.getUser() + "_order" + ".txt");

    try (FileInputStream fileInputStream = new FileInputStream(
        a); FileOutputStream fileOutputStream = new FileOutputStream(b)) {
      int i;
      while ((i = fileInputStream.read()) != -1) {
        fileOutputStream.write(i);
      }
    } catch (Exception e) {
      System.out.println("Error Found: " + e.getMessage());
    }
  }
}
