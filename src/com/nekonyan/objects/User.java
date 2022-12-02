package com.nekonyan.objects;

public class User {

  private static String username;

  public static String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    User.username = username;
  }
}
