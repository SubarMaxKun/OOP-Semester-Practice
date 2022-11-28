package com.nekonyan;

import com.nekonyan.objects.User;

public class UserController {
  User user = new User();

  public void createUser(String username) {
    user.setUsername(username);
  }

  public void getUser(){
    System.out.println(user.getUsername());
  }
}
