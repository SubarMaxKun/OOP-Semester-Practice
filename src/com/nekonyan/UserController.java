package com.nekonyan;

import com.nekonyan.objects.User;

public class UserController {
  User user = new User();

  public void CreateUser(String username) {
    user.setUsername(username);
  }

  public void GetUser(){
    System.out.println(user.getUsername());
  }
}
