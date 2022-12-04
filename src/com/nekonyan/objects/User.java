package com.nekonyan.objects;

public class User {

  private static String username;

  /**
   * @return
   */
  public static String getUsername() {
    return username;
  }

  /**
   * @param username
   */
  public void setUsername(String username) {
    User.username = username;
  }
}
