package com.nekonyan;

import com.nekonyan.objects.User;

public class UserController {
  User user = new User();

  /**
   * @param username
   */
  public void createUser(String username) {
    user.setUsername(username);
  }

  /**
   * @return
   */
  public String getUser(){
    return User.getUsername();
  }
}
