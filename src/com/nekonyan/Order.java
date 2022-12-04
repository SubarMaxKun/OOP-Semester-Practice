package com.nekonyan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
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
    System.out.println("Введіть місто та адрасу для доставки");
    deliveryAddress = "Адреса доставки: " + scanner.nextLine();
    pasteOrder();
  }

  private void pasteOrder() {
    String date = String.valueOf(LocalDate.now());
    int orderNumber = 1000 + new Random().nextInt(9000);
    File cart = new File("./carts_orders/" + userController.getUser() + "_cart"
        + ".txt");
    File order = new File("./carts_orders/" + userController.getUser() + "_order_" + date + "_#" + orderNumber + ".txt");

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
