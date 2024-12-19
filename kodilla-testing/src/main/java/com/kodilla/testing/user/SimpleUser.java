package com.kodilla.testing.user;

public class SimpleUser  {
  private final String userName;
  private final String realName;

  public SimpleUser(String userName, String realName) {

    this.userName = userName;
    this.realName = realName;
  }

  public String getUserName() {
    return userName;
  }

  public String getRealName() {
    return realName;
  }
}
