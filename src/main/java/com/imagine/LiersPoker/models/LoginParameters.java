package com.imagine.LiersPoker.models;

public class LoginParameters {
    @Override
    public String toString() {
        return "LoginParameters{" +
                "RoomNumber=" + RoomNumber +
                ", UserName='" + UserName + '\'' +
                '}';
    }

    private int RoomNumber;
    private String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }
}
