package com.imagine.LiersPoker.models;


import java.util.ArrayList;

public class PlayRoom {
    final static  int RoomMaxPlayers = 4 ;
    public PlayRoom (int RoomNumber){
        playerList = new ArrayList(RoomMaxPlayers);
        setRoomNumber(RoomNumber);
    }

    ArrayList playerList;
    int roomNumber ;

    public ArrayList getPlayerList() {
        return playerList;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public int getNumberOfPlayersInRoom(){
        return playerList.size();
    }
    public void AddPlayerToRoom(String playerName, int roomNumber){
       if (playerName == null || playerName.isEmpty()){
           throw new RuntimeException("player name can`t be empty");
       }
        if (roomNumber != getRoomNumber()){
            throw new RuntimeException("Room number not correct");
        }
        if (getNumberOfPlayersInRoom() == RoomMaxPlayers){
            throw new RuntimeException("Can`t add player, room is full");
        }
        playerList.add(playerName);
    }


}
