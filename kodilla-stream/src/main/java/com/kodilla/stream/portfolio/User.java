package com.kodilla.stream.portfolio;

import java.util.Objects;

public final class User {
  private final String userName;
  private final String realName;

  public User(final String userNname, final String realName) {
    this.userName = userNname;
    this.realName = realName;
  }

  public String getUserName() {
    return userName;
  }

  public String getRealName() {
    return realName;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;
    return Objects.equals(userName, user.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(userName);
  }

  @Override
  public String toString() {
    return "User{" +
        "userName='" + userName + '\'' +
        ", realName='" + realName + '\'' +
        '}';
  }
}
