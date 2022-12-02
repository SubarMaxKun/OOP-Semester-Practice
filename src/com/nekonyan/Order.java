package com.nekonyan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Order {

  UserController userController = new UserController();
  Scanner scanner = new Scanner(System.in);
  String fullName;
  String deliveryAddress;

  public void createOrder() {
    addDeliveryInfo();
  }

  private void addDeliveryInfo() {
    System.out.println("Введіть ПІБ");
    fullName = "ПІБ замовника: " + scanner.nextLine();
    System.out.println("Введіть місто та адрасе для доставки");
    deliveryAddress = "Адреса доставки: " + scanner.nextLine();
    pasteOrder();
  }

  private void pasteOrder() {
    File cart = new File("./src/com/nekonyan/carts_orders/" + userController.getUser() + "_cart"
        + ".txt");
    File order = new File("./src/com/nekonyan/carts_orders/" + userController.getUser() + "_order" + ".txt");

    try (FileInputStream fileInputStream = new FileInputStream(
        cart); FileOutputStream fileOutputStream = new FileOutputStream(order)) {
      int i;
      while ((i = fileInputStream.read()) != -1) {
        fileOutputStream.write(i);
      }
      fileOutputStream.write((fullName + "\n").getBytes());
      fileOutputStream.write(deliveryAddress.getBytes());
      System.out.println("--Ваше замовлення успішно створено--");
      new Router().chooseCatalogue();
    } catch (Exception e) {
      e.getStackTrace();
    }
  }
}
