package com.imagine.LiersPoker.models;

import java.util.HashMap;

@org.springframework.stereotype.Service
public class Lobby {
    HashMap<Integer, PlayRoom> playRoomsMap;
    public Lobby(){
        playRoomsMap = new HashMap<Integer, PlayRoom>() ;
    }
    public PlayRoom  AddPlayerToRoom(String playerName, int roomNumber){
        PlayRoom playRoom = playRoomsMap.get(roomNumber);
        if (playRoom == null){
            playRoomsMap.put(roomNumber , new PlayRoom(roomNumber));
            playRoom = playRoomsMap.get(roomNumber);
        }
        playRoom.AddPlayerToRoom(playerName,roomNumber);
        return playRoom;
    }
}
