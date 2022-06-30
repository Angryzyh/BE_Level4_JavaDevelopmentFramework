package com.angryzyh.thymeleaf.bean;

import java.util.Objects;

public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userSex;
    private Integer userAge;
    private String userEmail;

    public User() {
    }
    public User(String userName, String userPassword, String userSex, Integer userAge, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }
    public User(Integer userId, String userName, String userPassword, String userSex, Integer userAge, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userSex, user.userSex) && Objects.equals(userAge, user.userAge) && Objects.equals(userEmail, user.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPassword, userSex, userAge, userEmail);
    }
}
